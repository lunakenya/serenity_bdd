package com.demoblaze.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hooks de Cucumber para configurar el escenario Screenplay.
 *
 * <p>Responsabilidades:
 * <ul>
 *   <li>Inicializa el stage con OnlineCast antes de cada escenario.</li>
 *   <li>Pone al actor "el usuario" en el spotlight para los steps de Antecedente.</li>
 *   <li>Limpia el localStorage de Demoblaze antes de cada escenario para
 *       evitar interferencia del carrito entre escenarios.</li>
 *   <li>Libera recursos al finalizar el escenario.</li>
 * </ul>
 * </p>
 */
public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private static final String DEMOBLAZE_URL = "https://www.demoblaze.com";

    @Before(order = 0)
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        // Poner al actor en el spotlight para que los steps puedan usarlo
        OnStage.theActorCalled("el usuario");
        clearDemoblazeCart();
    }

    @After(order = 0)
    public void tidyUp() {
        OnStage.drawTheCurtain();
    }

    /**
     * Limpia el carrito de Demoblaze eliminando los datos de localStorage.
     * Esto es necesario porque Demoblaze persiste el carrito en localStorage
     * y puede causar interferencias entre escenarios.
     */
    private void clearDemoblazeCart() {
        try {
            WebDriver driver = BrowseTheWeb.as(OnStage.theActorCalled("el usuario")).getDriver();
            // Navegar primero a Demoblaze para que el origen sea correcto
            driver.get(DEMOBLAZE_URL);
            // Limpiar el localStorage del carrito
            ((JavascriptExecutor) driver).executeScript(
                    "window.localStorage.removeItem('truestock'); " +
                    "window.localStorage.removeItem('cartItem'); " +
                    "window.localStorage.clear();"
            );
            log.info("LocalStorage de Demoblaze limpiado correctamente.");
        } catch (Exception e) {
            log.warn("No se pudo limpiar el localStorage de Demoblaze: {}", e.getMessage());
        }
    }
}
