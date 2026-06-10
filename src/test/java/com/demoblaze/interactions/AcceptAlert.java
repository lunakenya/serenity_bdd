package com.demoblaze.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Interacción para aceptar el alert del navegador que aparece
 * cuando se agrega un producto al carrito en Demoblaze.
 *
 * <p>Esta interacción espera hasta 10 segundos a que el alert esté presente
 * antes de aceptarlo, lo que previene fallas por carga lenta.</p>
 */
@Subject("acepta el alert del navegador")
public class AcceptAlert implements Interaction {

    private static final int ALERT_TIMEOUT_SECONDS = 10;

    /**
     * Factory method para crear la interacción de forma legible.
     *
     * @return instancia instrumentada de AcceptAlert
     */
    public static AcceptAlert thatAppearsAfterAddingToCart() {
        return Tasks.instrumented(AcceptAlert.class);
    }

    @Override
    @Step("{0} acepta el alert del navegador")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ALERT_TIMEOUT_SECONDS));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
