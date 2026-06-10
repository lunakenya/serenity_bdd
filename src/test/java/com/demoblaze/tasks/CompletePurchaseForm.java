package com.demoblaze.tasks;

import com.demoblaze.models.PurchaseData;
import com.demoblaze.userinterfaces.PurchaseModal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.annotations.Step;

/**
 * Task para completar el formulario de compra con los datos del modelo PurchaseData.
 * Los datos se reciben desde el modelo — nunca hardcodeados aquí.
 */
@Subject("completa el formulario de compra")
public class CompletePurchaseForm implements Task {

    private final PurchaseData purchaseData;

    public CompletePurchaseForm(PurchaseData purchaseData) {
        this.purchaseData = purchaseData;
    }

    /**
     * Factory method para crear el Task de forma legible.
     *
     * @param data datos del comprador externalizados
     * @return instancia instrumentada de CompletePurchaseForm
     */
    public static CompletePurchaseForm with(PurchaseData data) {
        return Tasks.instrumented(CompletePurchaseForm.class, data);
    }

    @Override
    @Step("{0} completa el formulario de compra con los datos del pedido")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(PurchaseModal.NAME_FIELD),
                Enter.theValue(purchaseData.getBuyerName()).into(PurchaseModal.NAME_FIELD),

                Clear.field(PurchaseModal.COUNTRY_FIELD),
                Enter.theValue(purchaseData.getCountry()).into(PurchaseModal.COUNTRY_FIELD),

                Clear.field(PurchaseModal.CITY_FIELD),
                Enter.theValue(purchaseData.getCity()).into(PurchaseModal.CITY_FIELD),

                Clear.field(PurchaseModal.CARD_FIELD),
                Enter.theValue(purchaseData.getCardNumber()).into(PurchaseModal.CARD_FIELD),

                Clear.field(PurchaseModal.MONTH_FIELD),
                Enter.theValue(purchaseData.getMonth()).into(PurchaseModal.MONTH_FIELD),

                Clear.field(PurchaseModal.YEAR_FIELD),
                Enter.theValue(purchaseData.getYear()).into(PurchaseModal.YEAR_FIELD)
        );
    }
}
