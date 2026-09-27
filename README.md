# ReparaLab

![ReparaLab visual identity](images/logo.png)

Desktop application for managing a mobile device repair shop. This portfolio edition is based on a tool I built while learning Java and that was used by a real business. The business name, branding, database connection, and customer data are not part of this repository.

## Existing features

| Role | Main responsibilities |
| --- | --- |
| Administrator | Users, customers, devices, products, sales, receipt information, and cash closing |
| Data entry clerk | Device intake, customers, sales, shifts, and cash closing |
| Technician | Review and update device repair status |

The application also generates service orders, receipts, and PDFs. This edition does not add new modules.

## Technology

- Java 25 compilation target and Swing forms built with NetBeans
- [Scope and validation of the Java 25 upgrade](docs/java-25-upgrade.md)
- Maven
- MySQL Connector/J 8.4
- JasperReports 7.0.8 for service orders
- iText 5.5 for PDFs

The JRXML template was adapted to JasperReports 7 to use the security fixes in that series.

## Adapt ReparaLab for a repair shop

ReparaLab preserves its existing feature set as a starting point. To adapt it to another business:

1. Create your own database using `database/demo.sql` as a starting point. Replace the sample users and data. Do not publish customer data or real passwords.
2. Set `APP_DB_URL`, `APP_DB_USER`, and `APP_DB_PASSWORD` on the machine running the application. Give the MySQL user only the permissions it needs.
3. Review the business details, intake terms, and text in generated documents. Replace the generic images with your own assets if appropriate.
4. Test every role and the create, lookup, service order, sale, PDF, and printing flows locally with sample data.
5. Review [requirements.txt](requirements.txt), the [third-party notices](THIRD-PARTY-NOTICES.md), and the license section before distributing an adaptation.

The application uses relative paths for `images/` and `reports/`. Keep these directories alongside the application and launch it from the project root. A GitHub template preserves the repository contents and starts a new history; it does not configure a business deployment or grant additional usage rights.

## Run a local demo

You need JDK 25 or later, Maven 3.9.12 or later, and a local MySQL 8 instance. The schema in `database/demo.sql` was reconstructed from the code for this demo and contains only fictional data.

1. Import `database/demo.sql` into MySQL. Create a local user with access to `reparalab_demo`.
2. Set the application environment variables. For example, in PowerShell:

       $env:APP_DB_URL = 'jdbc:mysql://localhost:3306/reparalab_demo'
       $env:APP_DB_USER = '<local_user>'
       $env:APP_DB_PASSWORD = '<local_password>'

3. From the repository root, run:

       mvn clean install
       java -jar target/ReparaLab-3.0.0.jar

Launch from the repository root so the application can find `images/` and `reports/`. The `install` command copies dependencies to `target/lib/`. The application does not include a MySQL server or create the database automatically.

Sample accounts: `admin`, `capturista`, and `tecnico`. Each uses the password `demo1234`. These are fictional local accounts; change or remove them if you reuse the schema.

## Project layout

- `src/main/java/gui`: Swing windows and dialogs
- `src/main/java/com/bd`: MySQL access
- `src/main/java/com/construir` and `com/eventos`: tables and interaction
- `src/main/java/com/cortes` and `com/Ticket*`: cash closing and receipts
- `reports`: JRXML source template
- `database`: sample schema and users

## Scope and limitations

This repository does not include the private project's history, credentials from the original installation, customer data, or business images. New account passwords are stored with PBKDF2, and direct queries and search filters use parameters. Desktop integration with MySQL and printers needs manual validation in a local environment. CI checks compilation and automated tests for passwords and service orders.

The original design retains early application decisions, including SQL in UI components and relative file paths. These are documented so the portfolio description reflects the code as it is.

## Author

Diego Arambula.

## License and release status

The repository is **private**, and no v1.0.0 release has been published. This revision retains [AGPLv3](LICENSE), selected to distribute the application with iText 5. That license permits copying, modification, and redistribution under its terms; it does not meet the goal of preventing use without adaptation. A later license change also cannot revoke permissions already granted for earlier copies.

Before distributing a version under restrictive terms, iText 5 must be replaced. The effect of MySQL Connector/J (GPLv2 with the Universal FOSS Exception) and other dependencies must also be reviewed. Changing the license for original code does not change the licenses of third-party libraries. See the [third-party inventory](THIRD-PARTY-NOTICES.md). This repository is not a commercial license offer or a package ready for distribution under restrictive terms.

The first version is described as a draft in [CHANGELOG.md](CHANGELOG.md) and the [v1.0.0 release notes](docs/releases/RELEASE-v1.0.0.md). The [release notes template](docs/releases/TEMPLATE.md) guides future releases.
