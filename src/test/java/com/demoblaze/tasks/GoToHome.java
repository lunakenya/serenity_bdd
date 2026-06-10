package com.demoblaze.tasks;

import com.demoblaze.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Task para volver a la página principal (Home) de Demoblaze.
 * Se usa entre la adición de productos para volver al catálogo.
 */
@Subject("navega al inicio de Demoblaze")
public class GoToHome implements Task {

    /**
     * Factory method para crear el Task de forma legible.
     *
     * @return instancia instrumentada de GoToHome
     */
    public static GoToHome page() {
        return Tasks.instrumented(GoToHome.class);
    }

    @Override
    @Step("{0} navega a la página principal")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.HOME_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.HOME_LINK),
                WaitUntil.the(HomePage.PRODUCT_LIST, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
