# ReparaLab

![Identidad visual de ReparaLab](images/logo.png)

Aplicación de escritorio para gestionar la operación de un taller de reparación de dispositivos móviles. Es una versión de portafolio derivada de una herramienta que desarrollé durante mis primeros años de aprendizaje de Java y que se usó en un negocio real. El nombre, los gráficos, la conexión y los datos del negocio no forman parte de esta publicación.

## Funciones existentes

| Rol | Trabajo principal |
| --- | --- |
| Administrador | Usuarios, clientes, equipos, artículos, ventas, información de tickets y cortes |
| Capturista | Recepción de equipos, clientes, ventas, turnos y cortes |
| Técnico | Consulta y seguimiento del estado de los equipos |

La aplicación también genera órdenes de servicio, tickets y PDF. No se añadieron módulos nuevos para esta versión.

## Tecnología

- Java 25 como nivel de compilación y Swing con formularios de NetBeans
- [Alcance y validación de la migración a Java 25](docs/java-25-upgrade.md)
- Maven
- MySQL Connector/J 8.4
- JasperReports 7.0.8 para órdenes de servicio
- iText 5.5 para PDF

La plantilla JRXML se adaptó a JasperReports 7 para incorporar la corrección de seguridad de esa serie.

## Adaptar ReparaLab a un taller

ReparaLab se conserva como base de las funciones existentes. Para adaptarlo a otro negocio:

1. Crea una base de datos propia a partir de `database/demo.sql`. Sustituye los usuarios y datos ficticios. No publiques una copia con datos de clientes ni contraseñas reales.
2. Configura `APP_DB_URL`, `APP_DB_USER` y `APP_DB_PASSWORD` en el equipo de ejecución. Comprueba que el usuario de MySQL tenga únicamente los permisos necesarios.
3. Revisa los datos del negocio, las condiciones de recepción y los textos de los documentos generados. Sustituye las imágenes genéricas por recursos propios si corresponde.
4. Comprueba localmente cada rol y los flujos de alta, consulta, orden de servicio, venta, PDF e impresión con datos de prueba.
5. Consulta [requirements.txt](requirements.txt), [avisos de terceros](THIRD-PARTY-NOTICES.md) y la sección de licencia antes de distribuir una adaptación.

La aplicación usa rutas relativas para `images/` y `reports/`; conserva estos directorios junto al ejecutable y ejecútalo desde su raíz. La plantilla de GitHub conserva el contenido del repositorio y crea un historial nuevo; no sustituye la configuración del negocio ni concede permisos de uso adicionales.

## Ejecutar una demostración local

Requiere JDK 25 o posterior, Maven 3.9.12 o posterior y una instancia local de MySQL 8. El esquema de database/demo.sql fue reconstruido a partir del código para esta demostración y contiene solamente datos ficticios.

1. Importa database/demo.sql en MySQL. Crea un usuario local con permisos sobre reparalab_demo.
2. Configura las variables de entorno de la aplicación. Por ejemplo, en PowerShell:

       $env:APP_DB_URL = 'jdbc:mysql://localhost:3306/reparalab_demo'
       $env:APP_DB_USER = '<usuario_local>'
       $env:APP_DB_PASSWORD = '<contraseña_local>'

3. Desde la raíz del repositorio, ejecuta:

       mvn clean install
       java -jar target/ReparaLab-3.0.0.jar

El proceso debe iniciarse desde la raíz para encontrar los directorios images/ y reports/. El comando install copia las dependencias a target/lib/. La aplicación no incluye un servidor MySQL ni crea automáticamente la base de datos.

Cuentas de ejemplo: admin, capturista y tecnico. Cada una usa la contraseña demo1234. Son cuentas ficticias para uso local; cambia o elimina estas credenciales si reutilizas el esquema.

## Organización

- src/main/java/gui: ventanas y diálogos Swing
- src/main/java/com/bd: acceso a MySQL
- src/main/java/com/construir y com/eventos: tablas e interacción
- src/main/java/com/cortes y com/Ticket*: cierres y comprobantes
- reports: plantilla fuente JRXML
- database: esquema y usuarios de ejemplo

## Alcance y límites

Esta copia no incluye historial del repositorio privado, credenciales de la instalación original, datos de clientes ni imágenes del negocio. Las contraseñas de nuevas cuentas se guardan con PBKDF2 y las consultas directas y filtros de búsqueda usan parámetros. La integración de escritorio con MySQL e impresoras requiere validación manual en un entorno local; el CI verifica compilación y pruebas automatizadas de contraseñas y de la orden de servicio.

El diseño original conserva decisiones de una aplicación temprana, como SQL en componentes de interfaz y rutas de archivos relativas. Se documentan para presentar el trabajo con precisión, sin atribuirle una arquitectura que no tiene.

## Autor

Diego Arambula.

## Licencia y estado de publicación

El repositorio está **privado** y no hay un release v1.0.0 publicado. El código de esta revisión conserva la [AGPLv3](LICENSE), que se eligió para distribuirlo con iText 5. Esa licencia permite copiar, modificar y redistribuir bajo sus condiciones; no cumple el objetivo de impedir que terceros usen la aplicación sin adaptarla. Además, cambiar la licencia de una versión posterior no retira los permisos ya concedidos sobre copias anteriores.

Antes de distribuir una versión con términos restrictivos hay que sustituir iText 5 y revisar el efecto de MySQL Connector/J (GPLv2 con Universal FOSS Exception) y de las demás dependencias. La licencia de las bibliotecas no cambia al modificar la licencia del código propio. Consulta el [inventario de terceros](THIRD-PARTY-NOTICES.md). Este repositorio no es una oferta de licencia comercial ni un paquete listo para distribuir bajo términos restrictivos.

La primera versión está descrita como borrador en [CHANGELOG.md](CHANGELOG.md) y [notas v1.0.0](docs/releases/RELEASE-v1.0.0.md). La [plantilla de notas](docs/releases/TEMPLATE.md) guía futuros releases.
