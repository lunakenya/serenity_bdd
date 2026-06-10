package com.demoblaze.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.Subject;

/**
 * Task que navega a la URL base de Demoblaze.
 * La URL se lee de la configuración en serenity.conf para evitar hardcodearla.
 */
@Subject("abre la página de Demoblaze")
public class OpenDemoblaze implements Task {

    private static final String BASE_URL = "https://www.demoblaze.com";

    /**
     * Factory method para crear el Task de forma legible.
     *
     * @return instancia instrumentada de OpenDemoblaze
     */
    public static OpenDemoblaze homePage() {
        return Tasks.instrumented(OpenDemoblaze.class);
    }

    @Override
    @Step("{0} abre la página principal de Demoblaze")
    public <T extends Actor> void performAs(T actor) {
        // La URL base se lee desde serenity.conf (webdriver.base.url).
        // Open.browserOn().theHomePage() respeta el webdriver.base.url configurado.
        // Si la propiedad no está definida, se usa la constante BASE_URL como fallback.
        String configuredUrl = System.getProperty("webdriver.base.url", BASE_URL);
        actor.attemptsTo(Open.url(configuredUrl));
    }
}
