# Demoblaze E2E — Serenity BDD + Screenplay Pattern

Proyecto de pruebas funcionales automatizadas E2E del flujo de compra en [Demoblaze](https://www.demoblaze.com/), implementado con **Serenity BDD**, **Cucumber/Gherkin**, **Screenplay Pattern** y **Selenium WebDriver**.

## Stack Tecnológico

| Componente | Versión |
|---|---|
| Java | 17 |
| Maven | 3.8+ |
| Serenity BDD | 4.1.20 |
| Cucumber | 7.15 |
| Selenium WebDriver | (incluido en Serenity) |
| Google Chrome | Última versión estable |

## Ejecución Rápida

```bash
# Headless (por defecto)
mvn clean verify

# Con navegador visible
mvn clean verify -Dheadless.mode=false
```

## Reporte

Después de ejecutar, abrir:
```
target/site/serenity/index.html
```

## Documentación Completa

Ver **`readme.txt`** para instrucciones detalladas, troubleshooting y decisiones técnicas.

Ver **`conclusiones.txt`** para hallazgos y análisis del comportamiento de Demoblaze.
