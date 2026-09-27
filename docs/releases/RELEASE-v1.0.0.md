# Release v1.0.0 — ReparaLab

Estado: borrador; aún no publicado.
Base prevista: `main`, tras validar e integrar `develop`.

## Resumen

Primera versión de portafolio de ReparaLab, derivada de la funcionalidad existente y presentada como base adaptable para un taller de reparación de dispositivos móviles. El historial del proyecto privado original no forma parte de este repositorio.

## Alcance incluido

- Gestión de clientes, equipos, usuarios, productos, servicios, ventas y cortes según el rol.
- Generación de órdenes de servicio y otros documentos PDF.
- Demostración local con MySQL y datos ficticios.
- Compilación con Java 25, pruebas automatizadas y documentación de adaptación.

## Uso de la plantilla

Antes de usarla en un negocio, sustituir datos de demostración, configurar una base de datos y credenciales propias, revisar textos de recibos, condiciones, imágenes y flujos de impresión, y validar los formularios con datos reales de prueba. Consultar el README para el procedimiento.

## Artefactos

Pendientes de definir cuando se implemente el flujo de empaquetado y se resuelva la licencia.

## Validación

`mvn -B clean verify` se ejecutó en la rama `develop` con Java 25: seis pruebas correctas. La interacción con MySQL, ventanas Swing e impresoras requiere validación manual.

## Licencias y atribuciones

[LICENSE](../../LICENSE) y [THIRD-PARTY-NOTICES.md](../../THIRD-PARTY-NOTICES.md). Se debe resolver la incompatibilidad de la licencia restrictiva deseada con iText 5 antes de publicar el paquete.
