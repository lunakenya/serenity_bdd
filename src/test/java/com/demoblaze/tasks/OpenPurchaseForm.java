package com.demoblaze.tasks;

import com.demoblaze.userinterfaces.CartPage;
import com.demoblaze.userinterfaces.PurchaseModal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Task para abrir el formulario de compra (modal "Place Order").
 * Hace clic en el botón "Place Order" y espera a que el modal sea visible.
 */
@Subject("abre el formulario de compra")
public class OpenPurchaseForm implements Task {

    /**
     * Factory method para crear el Task de forma legible.
     *
     * @return instancia instrumentada de OpenPurchaseForm
     */
    public static OpenPurchaseForm byClickingPlaceOrder() {
        return Tasks.instrumented(OpenPurchaseForm.class);
    }

    @Override
    @Step("{0} abre el formulario de compra haciendo clic en Place Order")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPage.PLACE_ORDER_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CartPage.PLACE_ORDER_BUTTON),
                WaitUntil.the(PurchaseModal.NAME_FIELD, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
