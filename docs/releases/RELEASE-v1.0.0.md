# Release v1.0.0 ? ReparaLab

Estado: borrador; a?n no publicado.
Base prevista: `main`, tras validar e integrar `develop`.

## Resumen

Primera versi?n de portafolio de ReparaLab, derivada de la funcionalidad existente y presentada como base adaptable para un taller de reparaci?n de dispositivos m?viles. El historial del proyecto privado original no forma parte de este repositorio.

## Alcance incluido

- Gesti?n de clientes, equipos, usuarios, productos, servicios, ventas y cortes seg?n el rol.
- Generaci?n de ?rdenes de servicio y otros documentos PDF.
- Demostraci?n local con MySQL y datos ficticios.
- Compilaci?n con Java 25, pruebas automatizadas y documentaci?n de adaptaci?n.

## Uso de la plantilla

Antes de usarla en un negocio, sustituir datos de demostraci?n, configurar una base de datos y credenciales propias, revisar textos de recibos, condiciones, im?genes y flujos de impresi?n, y validar los formularios con datos reales de prueba. Consultar el README para el procedimiento.

## Artefactos

Pendientes de definir cuando se implemente el flujo de empaquetado y se resuelva la licencia.

## Validaci?n

`mvn -B clean verify` se ejecut? en la rama `develop` con Java 25: seis pruebas correctas. La interacci?n con MySQL, ventanas Swing e impresoras requiere validaci?n manual.

## Licencias y atribuciones

[LICENSE](../../LICENSE) y [THIRD-PARTY-NOTICES.md](../../THIRD-PARTY-NOTICES.md). Se debe resolver la incompatibilidad de la licencia restrictiva deseada con iText 5 antes de publicar el paquete.
