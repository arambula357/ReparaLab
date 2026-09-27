#!/usr/bin/env python3
"""Build a distributable ZIP from a completed Maven install."""

from pathlib import Path, PurePosixPath
import hashlib
import re
import shutil
import sys
import xml.etree.ElementTree as ET
import zipfile

ROOT = Path(__file__).resolve().parents[1]
POM = ET.parse(ROOT / "pom.xml").getroot()
VERSION = POM.findtext("{http://maven.apache.org/POM/4.0.0}version")
NAME = f"ReparaLab-{VERSION}"
TARGET = ROOT / "target"
DIST = TARGET / "release"
STAGE = DIST / NAME


def required(path: Path) -> Path:
    if not path.exists():
        raise FileNotFoundError(f"Missing release input: {path}")
    return path


def copy_file(source: Path, relative: str) -> None:
    destination = STAGE / relative
    destination.parent.mkdir(parents=True, exist_ok=True)
    shutil.copy2(required(source), destination)


def copy_tree(source: Path, relative: str) -> None:
    required(source)
    shutil.copytree(source, STAGE / relative)


def dependency_names() -> set[str]:
    notices = (ROOT / "THIRD-PARTY-NOTICES.md").read_text(encoding="utf-8")
    coordinates = re.findall(r"^\| `([^`:]+:[^`:]+:[^`]+)`", notices, re.MULTILINE)
    return {f"{artifact}-{version}.jar" for group, artifact, version in
            (coordinate.split(":") for coordinate in coordinates)}


def copy_library_notices(jars: list[Path]) -> None:
    allowed = ("LICENSE", "LICENCE", "NOTICE", "COPYING", "COPYRIGHT")
    for jar in jars:
        count = 0
        with zipfile.ZipFile(jar) as archive:
            for entry in archive.infolist():
                path = PurePosixPath(entry.filename)
                if entry.is_dir() or path.is_absolute() or ".." in path.parts:
                    continue
                name = path.name.upper()
                if not name.startswith(allowed) or entry.file_size > 2_000_000:
                    continue
                if name.endswith((".CLASS", ".JAVA")):
                    continue
                destination = STAGE / "THIRD-PARTY-LICENSES" / jar.stem / Path(*path.parts)
                destination.parent.mkdir(parents=True, exist_ok=True)
                destination.write_bytes(archive.read(entry))
                count += 1
        if count == 0:
            fallback = ROOT / "licenses" / f"{jar.stem}-LICENSE.txt"
            copy_file(fallback, f"THIRD-PARTY-LICENSES/{jar.stem}/LICENSE.txt")


def main() -> None:
    if len(sys.argv) != 1:
        raise SystemExit("Usage: python3 scripts/package_release.py")
    if STAGE.exists():
        shutil.rmtree(STAGE)
    DIST.mkdir(parents=True, exist_ok=True)
    STAGE.mkdir()

    copy_file(TARGET / f"{NAME}.jar", f"{NAME}.jar")
    jars = sorted(required(TARGET / "lib").glob("*.jar"))
    actual = {jar.name for jar in jars}
    expected = dependency_names()
    if actual != expected:
        raise ValueError(f"Runtime libraries do not match notices: missing={sorted(expected - actual)}, extra={sorted(actual - expected)}")
    for jar in jars:
        copy_file(jar, f"lib/{jar.name}")
    copy_library_notices(jars)

    copy_tree(ROOT / "src", "src")
    copy_file(ROOT / "pom.xml", "pom.xml")
    copy_tree(ROOT / "images", "images")
    copy_tree(ROOT / "reports", "reports")
    copy_file(ROOT / "database" / "demo.sql", "database/demo.sql")
    for name in ("LICENSE", "README.md", "CHANGELOG.md", "CONTRIBUTING.md",
                 "THIRD-PARTY-NOTICES.md", "requirements.txt"):
        copy_file(ROOT / name, name)
    copy_file(ROOT / "docs" / "releases" / f"RELEASE-v{VERSION}.md",
              f"docs/releases/RELEASE-v{VERSION}.md")

    archive_path = DIST / f"{NAME}.zip"
    with zipfile.ZipFile(archive_path, "w", compression=zipfile.ZIP_DEFLATED) as archive:
        for path in sorted(STAGE.rglob("*")):
            if path.is_file():
                archive.write(path, path.relative_to(DIST))
    digest = hashlib.sha256(archive_path.read_bytes()).hexdigest()
    checksum_path = DIST / f"{NAME}.sha256"
    checksum_path.write_text(f"{digest}  {archive_path.name}\n", encoding="ascii")
    print(f"Built {archive_path} with {len(jars)} runtime libraries")
    print(f"SHA-256: {digest}")


if __name__ == "__main__":
    main()
