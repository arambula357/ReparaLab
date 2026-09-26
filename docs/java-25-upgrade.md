# Migración a Java 25

ReparaLab compila con `maven.compiler.release=25` y requiere JDK 25 para ejecutarse. El workflow de GitHub Actions ejecuta `mvn -B clean verify` con Temurin 25. No se modificó el código Java ni las dependencias de producción durante esta migración.

## Verificación

- Compilación y pruebas locales con JDK 25.0.2 y Maven 3.9.16: `mvn -B clean verify` completó correctamente.
- Maven compiló 36 archivos de producción y ejecutó 3 pruebas de `PasswordUtilTest`, sin fallos.
- La plantilla `reports/OrdenServicio.jrxml` compiló con JasperReports 7 y produjo un PDF de prueba mediante `JREmptyDataSource` bajo Java 25. Esta prueba no valida contenido real ni conexión a MySQL.
- GitHub Actions compiló y ejecutó las pruebas con Temurin 25 en el PR #9 y en `main`.

## Alcance pendiente

Las pruebas automatizadas no cubren conexión a MySQL, ventanas Swing, contenido real de PDF ni impresión. Esos flujos requieren una comprobación manual en un entorno con base de datos y dispositivos configurados. No se generó un informe de cobertura.

El análisis de vulnerabilidades realizado durante la migración incluyó seis dependencias directas y no encontró CVE conocidas corregibles en ellas. No examinó todas las dependencias transitivas; ese resultado no representa una auditoría completa del árbol de dependencias.

## Compatibilidad

Los artefactos compilados para Java 25 no pueden ejecutarse con Java 8 o 17. La versión pública anterior permanece en el historial Git.

## Configuración de VS Code

La extensión **Language Support for Java** debe conocer la ruta local de un JDK 25 para importar el proyecto Maven. En VS Code, ejecuta `Java: Configure Java Runtime` y asigna un JDK 25 al entorno `JavaSE-25`.

También puedes crear `.vscode/settings.json` en tu equipo con este ejemplo y sustituir la ruta por la de tu instalación:

```json
{
  "java.configuration.updateBuildConfiguration": "automatic",
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-25",
      "path": "C:/ruta/al/jdk-25",
      "default": true
    }
  ]
}
```

`.vscode/` está excluido de Git porque las rutas de instalación varían entre equipos. Después de configurar el JDK, ejecuta `Java: Clean Java Language Server Workspace` desde la paleta de comandos y acepta el reinicio. El JDK usado por la terminal puede ser diferente; compruébalo con `mvn -version` antes de compilar localmente.
