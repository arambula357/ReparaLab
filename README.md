# ReparaLab

![Identidad visual de ReparaLab](images/logo.png)

Aplicaci?n de escritorio para gestionar la operaci?n de un taller de reparaci?n de dispositivos m?viles. Es una versi?n de portafolio derivada de una herramienta que desarroll? durante mis primeros a?os de aprendizaje de Java y que se us? en un negocio real. El nombre, los gr?ficos, la conexi?n y los datos del negocio no forman parte de esta publicaci?n.

## Funciones existentes

| Rol | Trabajo principal |
| --- | --- |
| Administrador | Usuarios, clientes, equipos, art?culos, ventas, informaci?n de tickets y cortes |
| Capturista | Recepci?n de equipos, clientes, ventas, turnos y cortes |
| T?cnico | Consulta y seguimiento del estado de los equipos |

La aplicaci?n tambi?n genera ?rdenes de servicio, tickets y PDF. No se a?adieron m?dulos nuevos para esta versi?n.

## Tecnolog?a

- Java 25 como nivel de compilaci?n y Swing con formularios de NetBeans
- Maven
- MySQL Connector/J 8.4
- JasperReports 7.0.8 para ?rdenes de servicio
- iText 5.5 para PDF

La plantilla JRXML se adapt? a JasperReports 7 para incorporar la correcci?n de seguridad de esa serie.

## Ejecutar una demostraci?n local

Requiere JDK 25 o posterior, Maven 3.9.12 o posterior y una instancia local de MySQL 8. El esquema de database/demo.sql fue reconstruido a partir del c?digo para esta demostraci?n y contiene solamente datos ficticios.

1. Importa database/demo.sql en MySQL. Crea un usuario local con permisos sobre reparalab_demo.
2. Configura las variables de entorno de la aplicaci?n. Por ejemplo, en PowerShell:

       $env:APP_DB_URL = 'jdbc:mysql://localhost:3306/reparalab_demo'
       $env:APP_DB_USER = '<usuario_local>'
       $env:APP_DB_PASSWORD = '<contrase?a_local>'

3. Desde la ra?z del repositorio, ejecuta:

       mvn clean install
       java -jar target/ReparaLab-3.0.0.jar

El proceso debe iniciarse desde la ra?z para encontrar los directorios images/ y reports/. El comando install copia las dependencias a target/lib/. La aplicaci?n no incluye un servidor MySQL ni crea autom?ticamente la base de datos.

Cuentas de ejemplo: admin, capturista y tecnico. Cada una usa la contrase?a demo1234. Son cuentas ficticias para uso local; cambia o elimina estas credenciales si reutilizas el esquema.

## Organizaci?n

- src/main/java/gui: ventanas y di?logos Swing
- src/main/java/com/bd: acceso a MySQL
- src/main/java/com/construir y com/eventos: tablas e interacci?n
- src/main/java/com/cortes y com/Ticket*: cierres y comprobantes
- reports: plantilla fuente JRXML
- database: esquema y usuarios de ejemplo

## Alcance y l?mites

Esta copia no incluye historial del repositorio privado, credenciales de la instalaci?n original, datos de clientes ni im?genes del negocio. Las contrase?as de nuevas cuentas se guardan con PBKDF2 y las consultas directas y filtros de b?squeda usan par?metros. La integraci?n de escritorio con MySQL e impresoras requiere validaci?n manual en un entorno local; el CI verifica compilaci?n y pruebas automatizadas de contrase?as.

El dise?o original conserva decisiones de una aplicaci?n temprana, como SQL en componentes de interfaz y rutas de archivos relativas. Se documentan para presentar el trabajo con precisi?n, sin atribuirle una arquitectura que no tiene.

## Autor

Diego Arambula.

## Licencia

ReparaLab se distribuye bajo la GNU Affero General Public License version 3 (AGPLv3). Consulta [LICENSE](LICENSE) para el texto completo. Esta licencia permite usar iText 5 bajo su modalidad de codigo abierto, siempre que se cumplan sus condiciones al distribuir la aplicacion.

Las dependencias conservan sus propias licencias y avisos. iText 5 utiliza AGPLv3; JasperReports Library declara LGPL; MySQL Connector/J 8.4.0 declara GPLv2 con Universal FOSS Exception 1.0. Si distribuyes los archivos de `target/lib/`, incluye tambien los avisos de licencia correspondientes a esas bibliotecas.
