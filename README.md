# 🚀 Demoblaze Web Automation Challenge

Suite de automatización End-to-End para la aplicación web Demoblaze utilizando **Serenity BDD**, **Screenplay Pattern**, **Selenium WebDriver**, **Cucumber** y **JUnit 5**.

El proyecto fue desarrollado siguiendo buenas prácticas de automatización QA enfocadas en:

* Mantenibilidad
* Escalabilidad
* Reutilización
* Legibilidad
* Separación de responsabilidades
* Evidencia automática

---

<p align="center">

![Serenity](https://img.shields.io/badge/SerenityBDD-4.2.9-blue?style=for-the-badge)

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk)

![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?style=for-the-badge&logo=selenium)

![Cucumber](https://img.shields.io/badge/Cucumber-7.x-23D96C?style=for-the-badge&logo=cucumber)

![JUnit](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5)

![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apachemaven)

</p>

---

# 📖 Descripción

Esta solución automatiza el flujo completo de compra dentro de la plataforma Demoblaze.

Sitio bajo prueba:

```text
https://www.demoblaze.com
````

La automatización cubre escenarios funcionales de usuario final, incluyendo:

* Navegación por catálogo
* Selección de productos
* Gestión del carrito
* Validación de productos agregados
* Proceso de compra
* Confirmación de orden
* Escenarios positivos y negativos

---

# 🎯 Objetivos

✅ Validar el flujo E2E de compra.

✅ Verificar la correcta gestión del carrito.

✅ Confirmar la generación de órdenes.

✅ Validar mensajes de confirmación.

✅ Ejecutar pruebas mediante tags.

✅ Generar reportes automáticos con Serenity.

---

# 🛠 Stack Tecnológico

| Tecnología         | Uso                         |
| ------------------ | --------------------------- |
| Java 17            | Lenguaje principal          |
| Serenity BDD       | Framework de automatización |
| Selenium WebDriver | Automatización Web          |
| Cucumber           | BDD                         |
| JUnit 5            | Ejecución                   |
| Maven              | Gestión de dependencias     |
| Chrome             | Navegador                   |

---

# 📂 Estructura del Proyecto

```text
src
└── test
    ├── java
    │
    └── com.demoblaze
        ├── interactions
        ├── models
        ├── questions
        ├── runners
        ├── stepdefinitions
        ├── tasks
        ├── userinterfaces
        └── utils
    │
    └── resources
        ├── features
        ├── testdata
        ├── serenity.conf
        └── logback-test.xml
```

---

# ⚙️ Arquitectura de Automatización

La solución utiliza el patrón Screenplay.

## 🎭 Actors

Representan a los usuarios del sistema.

```text
Actor
```

---

## 📝 Tasks

Contienen flujos completos de negocio.

```text
AgregarProducto
RealizarCompra
```

---

## 🔍 Questions

Permiten validar resultados esperados.

```text
MensajeConfirmacion
ProductosEnCarrito
```

---

## 🖥 User Interfaces

Centralizan los localizadores.

```text
HomePage
CartPage
PurchaseForm
```

---

# 📋 Requisitos Previos

## Java

```bash
java -version
```

Resultado esperado:

```text
Java 17+
```

---

## Maven

```bash
mvn -version
```

Resultado esperado:

```text
Apache Maven 3.8+
```

---

## Chrome

Instalar una versión actualizada de Google Chrome.

---

# 🚀 Instalación

## Clonar repositorio

```bash
git clone https://github.com/lunakenya/serenity_bdd.git
```

Ingresar al proyecto:

```bash
cd serenity_bdd-master
```

Instalar dependencias:

```bash
mvn clean install
```

---

# ▶️ Ejecución

## Ejecutar toda la suite

```bash
mvn clean verify
```

---

## Ejecutar Smoke Tests

```bash
mvn clean verify -Dcucumber.filter.tags="@smoke"
```

---

## Ejecutar Regresión

```bash
mvn clean verify -Dcucumber.filter.tags="@regression"
```

---

## Ejecutar Casos Críticos

```bash
mvn clean verify -Dcucumber.filter.tags="@critical"
```

---

## Ejecutar Escenarios Negativos

```bash
mvn clean verify -Dcucumber.filter.tags="@negative"
```

---

# 📊 Cobertura de Pruebas

| ID     | Escenario                       |
| ------ | ------------------------------- |
| TC-001 | Compra exitosa                  |
| TC-002 | Agregar producto al carrito     |
| TC-003 | Agregar múltiples productos     |
| TC-004 | Compra con datos válidos        |
| TC-005 | Compra con datos incompletos    |
| TC-006 | Validación de mensajes de error |

---

# 🔍 Estrategias Implementadas

## Screenplay Pattern

Permite:

* Mayor mantenibilidad
* Menor acoplamiento
* Reutilización de componentes

---

## Evidencias Automáticas

Configuración:

```hocon
take.screenshots = FOR_EACH_ACTION
```

Genera evidencia de cada paso ejecutado.

---

## Datos Externos

Los datos se encuentran desacoplados de los escenarios.

```text
src/test/resources/testdata
```

---

# 📈 Reportes

Serenity genera automáticamente reportes HTML.

Ubicación:

```text
target/site/serenity/index.html
```

---

# 📷 Información Disponible en Reportes

* Escenarios ejecutados
* Tiempo de ejecución
* Evidencias
* Screenshots
* Resultado por paso
* Trazabilidad completa

---

# 🧪 Resultado Esperado

```text
Tests run: X
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# 🧠 Buenas Prácticas Aplicadas

* Screenplay Pattern
* Principio SOLID
* Page Objects desacoplados
* Reutilización de Tasks
* Reutilización de Questions
* Datos externos
* Tags para ejecución selectiva
* Evidencia automática

---

# 👨‍💻 Autor

**Juan Chávez**

Automation QA Engineer

```

Este formato es el que normalmente se ve en portafolios QA Senior, desafíos técnicos, repositorios corporativos y postulaciones para Automation Engineer.
```
