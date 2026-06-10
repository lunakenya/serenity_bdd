package com.demoblaze.tasks;

import com.demoblaze.userinterfaces.ConfirmationModal;
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
 * Task para finalizar la compra.
 * Hace clic en el botón "Purchase" y espera la confirmación del pedido.
 */
@Subject("finaliza la compra")
public class FinishPurchase implements Task {

    /**
     * Factory method para crear el Task de forma legible.
     *
     * @return instancia instrumentada de FinishPurchase
     */
    public static FinishPurchase byClickingPurchase() {
        return Tasks.instrumented(FinishPurchase.class);
    }

    @Override
    @Step("{0} finaliza la compra haciendo clic en Purchase")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PurchaseModal.PURCHASE_BUTTON),
                WaitUntil.the(ConfirmationModal.CONFIRMATION_TITLE, isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
}
