# Java 25 upgrade

ReparaLab compiles with `maven.compiler.release=25` and requires JDK 25 to run. The GitHub Actions workflow runs `mvn -B clean verify` with Temurin 25. No Java source code or production dependencies were changed as part of this upgrade.

## Validation at the time of the upgrade

- Local build and tests with JDK 25.0.2 and Maven 3.9.16: `mvn -B clean verify` completed successfully.
- Maven compiled 36 production files and ran three `PasswordUtilTest` tests without failures.
- `reports/OrdenServicio.jrxml` compiled with JasperReports 7 and produced a test PDF using `JREmptyDataSource` under Java 25. This did not validate actual content or a MySQL connection.
- GitHub Actions built and ran the tests with Temurin 25 in PR #9 and on `main`.

## Validation limits

At the time of the upgrade, automated tests did not cover the MySQL connection, Swing windows, real PDF content, or printing. Those flows require manual checks in an environment with a configured database and devices. No coverage report was generated.

The vulnerability review performed during the upgrade covered six direct dependencies and found no known fixable CVEs in them. It did not inspect every transitive dependency, so it was not a full dependency-tree audit.

## Compatibility

Artifacts compiled for Java 25 cannot run on Java 8 or 17. The earlier public version remains in Git history.

## VS Code configuration

The **Language Support for Java** extension needs the local path to a JDK 25 to import the Maven project. In VS Code, run `Java: Configure Java Runtime` and assign a JDK 25 to `JavaSE-25`.

You can also create `.vscode/settings.json` on your machine using this example, replacing the path with your installation path:

```json
{
  "java.configuration.updateBuildConfiguration": "automatic",
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-25",
      "path": "C:/path/to/jdk-25",
      "default": true
    }
  ]
}
```

`.vscode/` is excluded from Git because installation paths vary between machines. After configuring the JDK, run `Java: Clean Java Language Server Workspace` from the command palette and accept the restart. The JDK used by the terminal may differ; check it with `mvn -version` before building locally.
