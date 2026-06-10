package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Selectores del modal de compra (Place Order) en Demoblaze.
 * Contiene los campos del formulario de datos del comprador.
 */
public class PurchaseModal {

    private PurchaseModal() {
        // Clase de constantes — no instanciar
    }

    /** Modal completo de "Place Order" */
    public static final Target MODAL =
            Target.the("modal Place Order").located(By.id("orderModal"));

    /** Campo nombre del comprador */
    public static final Target NAME_FIELD =
            Target.the("campo Nombre").located(By.id("name"));

    /** Campo país */
    public static final Target COUNTRY_FIELD =
            Target.the("campo País").located(By.id("country"));

    /** Campo ciudad */
    public static final Target CITY_FIELD =
            Target.the("campo Ciudad").located(By.id("city"));

    /** Campo número de tarjeta */
    public static final Target CARD_FIELD =
            Target.the("campo Tarjeta de crédito").located(By.id("card"));

    /** Campo mes de vencimiento */
    public static final Target MONTH_FIELD =
            Target.the("campo Mes").located(By.id("month"));

    /** Campo año de vencimiento */
    public static final Target YEAR_FIELD =
            Target.the("campo Año").located(By.id("year"));

    /** Botón "Purchase" dentro del modal */
    public static final Target PURCHASE_BUTTON =
            Target.the("botón Purchase")
                    .located(By.xpath("//button[contains(text(),'Purchase')]"));
}
