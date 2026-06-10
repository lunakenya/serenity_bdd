package com.demoblaze.runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

/**
 * Runner principal de Cucumber + Serenity BDD.
 *
 * <p>Configura el motor de Cucumber con JUnit Platform Suite, apuntando
 * a los features en español y a los glue de step definitions y hooks.</p>
 *
 * <p><b>Filtrado por tags:</b></p>
 * <pre>
 *   mvn clean verify                                         → 4 tests (todos)
 *   mvn clean verify -Dheadless.mode=true                   → 4 tests (headless)
 *   mvn clean verify -Dcucumber.filter.tags="@smoke"         → 1 test
 *   mvn clean verify -Dcucumber.filter.tags="@regression"    → 3 tests
 *   mvn clean verify -Dcucumber.filter.tags="@negative"      → 1 test
 *   mvn clean verify -Dcucumber.filter.tags="@outline"       → 2 tests
 * </pre>
 *
 * <p>El filtro de tags se pasa vía Maven Failsafe
 * {@code <configurationParameters>} en el {@code pom.xml},
 * que lee la property {@code cucumber.filter.tags} del sistema.</p>
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(
                key = Constants.GLUE_PROPERTY_NAME,
                value = "com.demoblaze.stepdefinitions"
        ),
        @ConfigurationParameter(
                key = Constants.PLUGIN_PROPERTY_NAME,
                value = "pretty, json:target/site/serenity/cucumber.json, " +
                        "io.cucumber.core.plugin.SerenityReporterParallel"
        )
        // cucumber.filter.tags se gestiona desde pom.xml <configurationParameters>
        // para permitir sobrescribir el valor con -Dcucumber.filter.tags="@tag"
})
public class DemoblazeRunner {
    // Runner declarativo — sin lógica aquí
}
