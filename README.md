# Demoblaze E2E Automation Framework

## Descripción

Framework de automatización de pruebas funcionales End-to-End (E2E) para la aplicación web **Demoblaze**, desarrollado con:

* Serenity BDD
* Screenplay Pattern
* Selenium WebDriver
* Cucumber (Gherkin)
* JUnit 5
* Maven
* Java 17

El objetivo del proyecto es validar el flujo de compra de productos dentro de la plataforma Demoblaze mediante escenarios automatizados mantenibles, reutilizables y escalables.

---

# Arquitectura del Proyecto

El proyecto implementa el patrón **Screenplay**, recomendado por Serenity BDD para mejorar la legibilidad, reutilización y mantenimiento de las pruebas automatizadas.

```text
src
└── test
    ├── java
    │   └── com.demoblaze
    │       ├── interactions
    │       ├── models
    │       ├── questions
    │       ├── runners
    │       ├── stepdefinitions
    │       ├── tasks
    │       ├── userinterfaces
    │       └── utils
    │
    └── resources
        ├── features
        ├── testdata
        ├── serenity.conf
        └── logback-test.xml
```

## Descripción de Carpetas

| Carpeta         | Responsabilidad                                  |
| --------------- | ------------------------------------------------ |
| interactions    | Acciones simples reutilizables                   |
| models          | Objetos de datos utilizados por los escenarios   |
| questions       | Validaciones y consultas realizadas por el actor |
| runners         | Punto de entrada para la ejecución de pruebas    |
| stepdefinitions | Implementación de pasos Gherkin                  |
| tasks           | Flujos de negocio ejecutados por el actor        |
| userinterfaces  | Localizadores y mapeo de elementos UI            |
| features        | Escenarios escritos en Gherkin                   |
| testdata        | Datos de prueba                                  |
| utils           | Utilidades generales                             |

---

# Requisitos Previos

Antes de ejecutar el proyecto, verificar la instalación de:

## Java

```bash
java -version
```

Versión requerida:

```text
Java 17
```

---

## Maven

```bash
mvn -version
```

Versión recomendada:

```text
Maven 3.8+
```

---

## Google Chrome

Instalar una versión estable y actualizada de Google Chrome.

Verificar:

```bash
chrome --version
```

o

```bash
google-chrome --version
```

---

# Instalación

## 1. Clonar el repositorio

```bash
git clone https://github.com/lunakenya/serenity_bdd.git
```

## 2. Ingresar al proyecto

```bash
cd serenity_bdd-master
```

## 3. Descargar dependencias

```bash
mvn clean install -DskipTests
```

---

# Ejecución de Pruebas

## Ejecutar todos los escenarios

```bash
mvn clean verify
```

---

## Ejecutar con navegador visible

Por defecto el framework corre en modo Headless.

Para visualizar el navegador:

```bash
mvn clean verify -Dheadless.mode=false
```

---

## Ejecutar por Tags

### Smoke

```bash
mvn clean verify -Dcucumber.filter.tags="@smoke"
```

### Regression

```bash
mvn clean verify -Dcucumber.filter.tags="@regression"
```

### Escenario Crítico

```bash
mvn clean verify -Dcucumber.filter.tags="@critical"
```

### Negativos

```bash
mvn clean verify -Dcucumber.filter.tags="@negative"
```

### Múltiples Tags

```bash
mvn clean verify -Dcucumber.filter.tags="@smoke and @critical"
```

---

# Escenarios Implementados

## Compra Exitosa

Valida que un usuario pueda:

1. Ingresar a Demoblaze.
2. Agregar múltiples productos al carrito.
3. Visualizar el carrito.
4. Completar el formulario de compra.
5. Finalizar la compra.
6. Visualizar el mensaje de confirmación.

Tag:

```gherkin
@smoke
@critical
@e2e
```

---

## Compra con Formulario Incompleto

Valida que la aplicación no procese una compra cuando existen campos obligatorios sin completar.

Tag:

```gherkin
@negative
@regression
```

---

## Agregar Productos Individualmente

Valida mediante Scenario Outline que distintos productos puedan agregarse correctamente al carrito.

Tag:

```gherkin
@outline
@regression
```

---

# Configuración del Proyecto

Archivo:

```text
src/test/resources/serenity.conf
```

Configuraciones principales:

## URL Base

```hocon
webdriver.base.url = "https://www.demoblaze.com"
```

---

## Driver

```hocon
webdriver.driver = chrome
```

---

## Screenshots

```hocon
take.screenshots = FOR_EACH_ACTION
```

Genera evidencia visual de cada acción ejecutada.

---

## Headless

```hocon
headless.mode = true
```

Puede sobrescribirse desde Maven:

```bash
-Dheadless.mode=false
```

---

# Datos de Prueba

Ubicación:

```text
src/test/resources/testdata/
```

Archivo:

```text
purchase-data.properties
```

Contiene la información utilizada para completar el formulario de compra durante la ejecución de pruebas.

---

# Reportes

Una vez finalizada la ejecución, Serenity genera automáticamente un reporte HTML.

Ubicación:

```text
target/site/serenity/index.html
```

Abrir en navegador:

```bash
start target/site/serenity/index.html
```

o

```bash
open target/site/serenity/index.html
```

---

# Evidencias Generadas

Durante la ejecución se generan:

* Capturas de pantalla.
* Resultados de escenarios.
* Trazabilidad de pasos.
* Historial de ejecución.
* Evidencias de errores.

Ubicación:

```text
target/site/serenity
```

---

# Solución de Problemas

## Error de Dependencias Maven

Ejecutar:

```bash
mvn clean install -U
```

---

## Chrome No Compatible

Actualizar navegador:

```text
Google Chrome
```

y limpiar dependencias:

```bash
mvn clean
```

---

## Error de Ejecución Headless

Ejecutar en modo visible:

```bash
mvn clean verify -Dheadless.mode=false
```

---

## Reporte No Generado

Generar nuevamente:

```bash
mvn serenity:aggregate
```

---

# Buenas Prácticas Implementadas

* Screenplay Pattern.
* Separación de responsabilidades.
* Reutilización de Tasks.
* Reutilización de Questions.
* Datos externos al código.
* Escenarios legibles mediante Gherkin.
* Evidencias automáticas.
* Ejecución parametrizable mediante tags.
* Configuración centralizada.

---

# Tecnologías Utilizadas

| Tecnología         | Versión                |
| ------------------ | ---------------------- |
| Java               | 17                     |
| Maven              | 3.8+                   |
| Serenity BDD       | 4.2.9                  |
| Cucumber           | 7.15.0                 |
| JUnit              | 5.10.2                 |
| Selenium WebDriver | Incluido en Serenity   |
| Chrome             | Última versión estable |

---

# Autor

Luna Kenya
