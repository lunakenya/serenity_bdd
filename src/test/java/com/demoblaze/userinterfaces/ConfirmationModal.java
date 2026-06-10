package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Selectores del modal de confirmación de compra exitosa en Demoblaze.
 * Aparece después de completar correctamente el formulario de pedido.
 */
public class ConfirmationModal {

    private ConfirmationModal() {
        // Clase de constantes — no instanciar
    }

    /** Contenedor principal del modal de confirmación (SweetAlert) */
    public static final Target CONFIRMATION_DIALOG =
            Target.the("modal de confirmación de compra")
                    .located(By.cssSelector(".sweet-alert"));

    /** Título principal con "Thank you for your purchase!" */
    public static final Target CONFIRMATION_TITLE =
            Target.the("título de confirmación")
                    .located(By.cssSelector(".sweet-alert h2"));

    /** Texto con los detalles del pedido (ID, importe, etc.) */
    public static final Target CONFIRMATION_DETAILS =
            Target.the("detalles de la confirmación")
                    .located(By.cssSelector(".sweet-alert p.lead"));

    /** Botón OK para cerrar el modal de confirmación */
    public static final Target OK_BUTTON =
            Target.the("botón OK de confirmación")
                    .located(By.cssSelector(".sweet-alert button.confirm"));
}
