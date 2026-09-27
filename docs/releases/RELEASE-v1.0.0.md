# Release v1.0.0 - ReparaLab

Status: draft; not published.
Planned base: `main`, after validating and integrating `develop`.

## Summary

First ReparaLab portfolio edition, based on the existing features and presented as a starting point that can be adapted for a mobile device repair shop. The original private project's history is not part of this repository.

## Included scope

- Customer, device, user, product, service, sale, and cash closing management according to role.
- Service order and other PDF document generation.
- Local MySQL demo with fictional data.
- Java 25 build, automated tests, and adaptation documentation.

## Using the template

Before using it for a business, replace demo data, set up a database and credentials, review receipt text, terms, images, and printing flows, and validate the forms with realistic test data. See the README for the procedure.

## Artifacts

To be defined after the packaging workflow is implemented and licensing is resolved.

## Validation

`mvn -B clean verify` ran on `develop` with Java 25: six tests passed. MySQL interaction, Swing windows, and printers require manual validation.

## Licenses and attribution

See [LICENSE](../../LICENSE) and [THIRD-PARTY-NOTICES.md](../../THIRD-PARTY-NOTICES.md). The conflict between the desired restrictive license and iText 5 must be resolved before distributing the package.
