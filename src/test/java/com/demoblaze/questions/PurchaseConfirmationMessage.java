package com.demoblaze.questions;

import com.demoblaze.userinterfaces.ConfirmationModal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

/**
 * Question que retorna el texto del título del modal de confirmación de compra.
 *
 * <p>Lee el texto visible del elemento {@code ConfirmationModal.CONFIRMATION_TITLE}
 * y lo devuelve para que el StepDefinition pueda afirmar contra él.</p>
 */
@Subject("el mensaje de confirmación de compra")
public class PurchaseConfirmationMessage implements Question<String> {

    /**
     * Factory method para usar la Question con actor.asksFor().
     *
     * @return instancia de PurchaseConfirmationMessage
     */
    public static PurchaseConfirmationMessage displayed() {
        return new PurchaseConfirmationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConfirmationModal.CONFIRMATION_TITLE).answeredBy(actor).trim();
    }
}
