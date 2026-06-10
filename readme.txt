==============================================================================
DEMOBLAZE E2E - SERENITY BDD
Prueba Funcional Automatizada de Flujo de Compra
==============================================================================

DESCRIPCIÓN DEL RETO
----------------------
Este proyecto implementa pruebas funcionales automatizadas End-to-End (E2E) del
flujo de compra de la tienda en línea https://www.demoblaze.com/ utilizando el
framework Serenity BDD con el patrón Screenplay, Cucumber/Gherkin y Selenium WebDriver.

El flujo automatizado cubre:
  1. Apertura de la página de Demoblaze.
  2. Selección y adición de dos productos al carrito.
  3. Manejo del alert de confirmación "Product added".
  4. Navegación y validación del carrito de compras.
  5. Llenado del formulario de compra con datos externalizados.
  6. Finalización de la compra.
  7. Validación del mensaje de confirmación "Thank you for your purchase!".

==============================================================================

STACK TECNOLÓGICO
-----------------
  - Lenguaje:      Java 17
  - Build:         Maven 3.8+
  - Framework:     Serenity BDD 4.2.9
  - BDD:           Cucumber 7 / Gherkin (en español)
  - Patrón:        Screenplay Pattern
  - Browser:       Google Chrome (via WebDriverManager automático)
  - Selenium:      Selenium WebDriver (incluido en Serenity)
  - Reporte:       Serenity HTML Report

==============================================================================

PRERREQUISITOS
--------------
Antes de ejecutar, asegúrese de tener instalado:

  1. Java 17 o superior
     Verificar: java -version

  2. Apache Maven 3.8 o superior
     Verificar: mvn -version

  3. Google Chrome (versión reciente)
     Serenity utiliza WebDriverManager que descarga el ChromeDriver
     compatible automáticamente. NO es necesario instalar ChromeDriver manualmente.

  4. Conexión a internet
     Requerida para:
       a) Acceder a https://www.demoblaze.com/
       b) Descargar dependencias Maven en la primera ejecución.
       c) Descargar ChromeDriver via WebDriverManager.

==============================================================================

INSTALACIÓN
-----------
1. Clone o descargue este repositorio:
   git clone https://github.com/lunakenya/serenity_bdd.git
   cd demoblaze-serenity-e2e

2. Descargue las dependencias Maven (solo la primera vez):
   mvn dependency:resolve

==============================================================================

COMANDOS DE EJECUCIÓN
---------------------

** Ejecución estándar (todos los escenarios, modo headless):
   mvn clean verify
   → Ejecuta: 4 tests, 0 skipped (1 smoke + 1 negativo + 2 outline)

** Ejecución con navegador visible (recomendado para depuración):
   mvn clean verify -Dheadless.mode=false
   → Ejecuta: 4 tests con Chrome visible

** Ejecución SOLO del flujo E2E principal (smoke):
   mvn clean verify -Dcucumber.filter.tags="@smoke"
   → Ejecuta: 1 test activo, 3 skipped (solo la compra completa con dos productos)

** Ejecución de escenarios de regresión (negativo + outline):
   mvn clean verify -Dcucumber.filter.tags="@regression"
   → Ejecuta: 3 tests activos, 1 skipped (negativo + 2 outline)

** Ejecución SOLO del caso negativo:
   mvn clean verify -Dcucumber.filter.tags="@negative"
   → Ejecuta: 1 test activo, 3 skipped (formulario incompleto)

** Ejecución SOLO de pruebas de outline (productos individuales):
   mvn clean verify -Dcucumber.filter.tags="@outline"
   → Ejecuta: 2 tests activos, 2 skipped (Samsung galaxy s6 + Nokia lumia 1520)

** Ejecución del escenario crítico E2E completo:
   mvn clean verify -Dcucumber.filter.tags="@e2e"

NOTA SOBRE CONTEO:
   El JUnit Platform Suite engine reporta el total de escenarios registrados
   (incluidos los que aplica skip). El conteo relevante es "Failures: 0" y los
   escenarios activos vs. skipped en el output del runner.

==============================================================================

REPORTE SERENITY
----------------
Después de la ejecución, el reporte HTML se genera automáticamente en:

  target/site/serenity/index.html

Para abrirlo:
  - Linux/Mac: xdg-open target/site/serenity/index.html
  - Windows:   start target/site/serenity/index.html

El reporte incluye:
  - Resumen de escenarios ejecutados (pasados/fallidos).
  - Screenshots por cada acción (FOR_EACH_ACTION).
  - Detalles de cada paso con argumentos.
  - Evidencia del flujo completo de compra.

==============================================================================

ESTRUCTURA DEL PROYECTO
-----------------------
demoblaze-serenity-e2e/
├── pom.xml                          <- Configuración Maven y dependencias
├── readme.txt                       <- Este archivo
├── conclusiones.txt                 <- Hallazgos y conclusiones
├── .gitignore
└── src/test/
    ├── java/com/demoblaze/
    │   ├── runners/
    │   │   └── DemoblazeRunner.java     <- Runner Cucumber/Serenity (JUnit Platform)
    │   ├── stepdefinitions/
    │   │   ├── Hooks.java               <- Configuración de escenario Screenplay
    │   │   └── PurchaseStepDefinitions.java  <- Pasos BDD (solo orquestación)
    │   ├── tasks/
    │   │   ├── OpenDemoblaze.java       <- Abre la URL base
    │   │   ├── AddProductToCart.java    <- Agrega producto + acepta alert
    │   │   ├── GoToHome.java            <- Navega al home
    │   │   ├── GoToCart.java            <- Navega al carrito
    │   │   ├── OpenPurchaseForm.java    <- Abre el modal Place Order
    │   │   ├── CompletePurchaseForm.java <- Llena el formulario
    │   │   └── FinishPurchase.java      <- Hace clic en Purchase
    │   ├── questions/
    │   │   ├── ProductsInCart.java      <- Retorna lista de productos en carrito
    │   │   └── PurchaseConfirmationMessage.java <- Retorna texto de confirmación
    │   ├── userinterfaces/
    │   │   ├── HomePage.java            <- Selectores de la página principal
    │   │   ├── ProductPage.java         <- Selectores de página de producto
    │   │   ├── CartPage.java            <- Selectores del carrito
    │   │   ├── PurchaseModal.java       <- Selectores del formulario de compra
    │   │   └── ConfirmationModal.java   <- Selectores del modal de confirmación
    │   ├── models/
    │   │   └── PurchaseData.java        <- Modelo de datos de compra (Builder pattern)
    │   ├── utils/
    │   │   └── TestDataBuilder.java     <- Carga datos desde purchase-data.properties
    │   └── interactions/
    │       └── AcceptAlert.java         <- Acepta el alert del navegador
    └── resources/
        ├── features/
        │   └── purchase.feature         <- Escenarios BDD en español
        ├── serenity.conf                <- Configuración de Serenity BDD
        └── testdata/
            └── purchase-data.properties <- Datos de prueba externalizados

==============================================================================

ESCENARIOS CUBIERTOS Y TAGS
----------------------------
Cada escenario tiene tags que permiten ejecución selectiva.
ESTRUCTURA DE TAGS:

  @flujo_compra   → Tag de Feature (todos los escenarios lo heredan)
  @smoke          → Solo el escenario principal E2E completo (1 test)
  @critical       → Flujo de mayor impacto de negocio (1 test)
  @e2e            → Prueba End-to-End completa (1 test)
  @regression     → Escenarios complementarios: negativo + outline (3 tests)
  @negative       → Solo el caso negativo de formulario incompleto (1 test)
  @outline        → Solo las pruebas parametrizadas por producto (2 tests)

DETALLE POR ESCENARIO:

1. @compra_exitosa @smoke @critical @e2e
   Compra exitosa agregando dos productos al carrito
   - Agrega Samsung galaxy s6 y Nokia lumia 1520
   - Valida ambos productos en carrito
   - Completa formulario con datos externalizados
   - Valida mensaje "Thank you for your purchase!"

2. @formulario_incompleto @negative @regression
   Intento de compra con formulario incompleto
   - Abre el modal sin llenar campos
   - Verifica que la compra no se procesa
   - Documenta el comportamiento real de Demoblaze

3. @multiples_productos @outline @regression  (x2 ejemplos)
   Verificar que cada producto se puede agregar individualmente
   - Samsung galaxy s6 solo en carrito → validado
   - Nokia lumia 1520 solo en carrito → validado

==============================================================================

DATOS DE PRUEBA
---------------
Los datos de compra están externalizados en:
  src/test/resources/testdata/purchase-data.properties

Contenido actual:
  purchase.product1=Samsung galaxy s6
  purchase.product2=Nokia lumia 1520
  purchase.buyer.name=Juan Perez
  purchase.buyer.country=Colombia
  purchase.buyer.city=Bogota
  purchase.buyer.card=4111111111111111
  purchase.buyer.month=12
  purchase.buyer.year=2025

CÓMO CAMBIAR LOS DATOS:
1. Abra el archivo: src/test/resources/testdata/purchase-data.properties
2. Modifique los valores deseados.
3. Ejecute nuevamente: mvn clean verify

NOTA IMPORTANTE SOBRE PRODUCTOS:
Los nombres de los productos DEBEN coincidir EXACTAMENTE con el texto visible en la web.
Demoblaze puede cambiar su catálogo. Productos disponibles habituales:
  - Samsung galaxy s6
  - Nokia lumia 1520
  - Nexus 6
  - Samsung galaxy s7
  - Iphone 6 32gb
  - Sony xperia z5
  - HTC One M9
  - Sony vaio i5
  - Dell i7 8gb
  - 2017 Dell 15.6 Inch

==============================================================================

DECISIONES TÉCNICAS
-------------------
1. Screenplay Pattern:
   Los Tasks encapsulan acciones de usuario, las Questions validan resultados
   y los UserInterfaces centralizan los selectores. Los StepDefinitions solo
   orquestan, sin lógica de UI directa.

2. Datos Externalizados:
   TestDataBuilder carga los datos desde purchase-data.properties, evitando
   datos hardcodeados en el código de pruebas.

3. Manejo de Alerts:
   AcceptAlert usa WebDriverWait con ExpectedConditions.alertIsPresent()
   para esperar robustamente el alert sin Thread.sleep().

4. Headless Mode:
   Controlado via -Dheadless.mode=false/true. Por defecto es true (headless).
   Serenity lee la propiedad desde serenity.conf: headless.mode = ${?headless.mode}.

5. URL Centralizada:
   webdriver.base.url definida en serenity.conf. OpenDemoblaze la lee desde
   System.getProperty("webdriver.base.url") con fallback a la constante BASE_URL.

6. Screenshots:
   serenity.take.screenshots = FOR_EACH_ACTION en serenity.conf.
   Genera evidencia visual de cada interacción.

7. Esperas:
   Se usa WaitUntil de Serenity Screenplay para esperar elementos visibles,
   evitando Thread.sleep() salvo casos estrictamente necesarios.

==============================================================================

TROUBLESHOOTING
---------------
PROBLEMA: "No product found" / El producto no se encuentra en el catálogo
SOLUCIÓN: Verificar que el nombre en purchase-data.properties coincida EXACTAMENTE
          con el texto visible en demoblaze.com. El catálogo puede variar.

PROBLEMA: Alert no aparece a tiempo / TimeoutException en AcceptAlert
SOLUCIÓN: El timeout actual es 10 segundos. Si la red es lenta, puede aumentarse
          la constante ALERT_TIMEOUT_SECONDS en AcceptAlert.java.

PROBLEMA: ChromeDriver no compatible con la versión de Chrome
SOLUCIÓN: WebDriverManager descarga automáticamente el driver correcto.
          Si hay proxy corporativo, puede fallar. Use: mvn clean verify -Dwdm.proxyHost=... 

PROBLEMA: El carrito muestra productos de sesiones anteriores
SOLUCIÓN: Demoblaze usa localStorage para el carrito. Limpie las cookies/localStorage
          del browser, o use el modo incognito (agregar --incognito en chromeOptions).

PROBLEMA: TimeoutException al cargar el carrito
SOLUCIÓN: GoToCart espera el botón Place Order (15 seg) y adicionalmente
          aguarda a que existan celdas en la tabla (#tbodyid tr td) porque
          Demoblaze carga los ítems asíncronamente. Si la carga es muy lenta,
          aumentar CART_ITEMS_TIMEOUT en GoToCart.java (actual: 15 segundos).

PROBLEMA: Error de compilación con Java < 17
SOLUCIÓN: Verificar con java -version. El proyecto requiere Java 17+.

==============================================================================

NOTA DE REPRODUCIBILIDAD
-------------------------
Este proyecto fue diseñado para ser ejecutado directamente después de clonar
el repositorio, sin configuración manual adicional. Las únicas dependencias
externas son: Java 17, Maven, Google Chrome y conexión a internet.

El primer mvn clean verify descargará aprox. 150-200 MB de dependencias.
Las ejecuciones subsiguientes serán significativamente más rápidas.

==============================================================================
Autor: Kenya Luna
Fecha: Junio 2026
Framework: Serenity BDD 4.2.9 + Cucumber 7 + Screenplay Pattern
==============================================================================
