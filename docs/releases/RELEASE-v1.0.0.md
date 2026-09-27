# Release v1.0.0 - ReparaLab

Date: 2026-09-27
Base: `main` (validated on `develop`)

## Summary

The first official ReparaLab portfolio release offers the existing desktop repair-shop features as a starting point for independent adaptations. The original private project's history is not part of this repository.

## Included scope

- Customer, device, user, product, service, sale, and cash closing management according to role.
- Service order and other PDF document generation.
- Local MySQL demo with fictional data and environment-based database configuration.
- Java 25 build, automated CI, and six tests for passwords and service orders.
- The in-app update check and `version.txt` were removed; the version information dialog remains.

## Using the template

Create your own repository from the ReparaLab template or fork it to adapt the software for a business. Replace demo data and credentials, review receipt text and terms, and test the GUI, database, PDF, and printing flows with realistic sample data. These adaptations do not need to be submitted to the ReparaLab repository. See the README and CONTRIBUTING.md.

## Requirements and setup

- JDK 25 or later, Maven 3.9.12 or later for source builds, and MySQL 8 for the local demo.
- Set `APP_DB_URL`, `APP_DB_USER`, and `APP_DB_PASSWORD` before launching.
- See [README.md](../../README.md) and [requirements.txt](../../requirements.txt).

## Artifacts

- `ReparaLab-1.0.0.zip`: application JAR, source code and Maven build file, 36 runtime libraries, images, reports, demo schema, documentation, and license notices.
- `ReparaLab-1.0.0.sha256`: SHA-256 checksum of the ZIP.

## Validation

- `mvn -B clean install`: six tests passed with Java 25. The release workflow rebuilds and runs the same command from the `v1.0.0` tag.
- The ZIP was inspected for all 36 runtime libraries and its required resources and notices.
- MySQL interaction, Swing windows, and printers still require manual validation in a local environment.

## Licenses and attribution

Original code and iText 5 are covered by [AGPLv3](../../LICENSE). See [THIRD-PARTY-NOTICES.md](../../THIRD-PARTY-NOTICES.md) for the other libraries. The ZIP includes copies of license and notice files from the runtime JARs, plus separate BSD-3-Clause texts for protobuf-java and Adobe XMPCore, whose JARs lack a license file.
