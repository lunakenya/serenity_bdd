package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Selectores de la página del carrito de compras en Demoblaze.
 */
public class CartPage {

    private CartPage() {
        // Clase de constantes — no instanciar
    }

    /** Tabla principal del carrito con los productos */
    public static final Target CART_TABLE =
            Target.the("tabla del carrito").located(By.id("tbodyid"));

    /** Filas de productos en el carrito */
    public static final Target CART_ITEMS =
            Target.the("items del carrito")
                    .located(By.cssSelector("#tbodyid tr"));

    /** Botón "Place Order" para abrir el modal de compra */
    public static final Target PLACE_ORDER_BUTTON =
            Target.the("botón Place Order")
                    .located(By.xpath("//button[contains(text(),'Place Order')]"));

    /**
     * Retorna el Target para validar que un producto específico
     * aparece como texto en alguna celda del carrito.
     *
     * @param productName nombre del producto a buscar
     * @return Target del elemento de la tabla
     */
    public static Target cartItemNamed(String productName) {
        return Target.the("producto '" + productName + "' en el carrito")
                .located(By.xpath(
                        "//table[@id='cart']//td[normalize-space(text())='" + productName + "']"));
    }

    /** Precio total del carrito */
    public static final Target TOTAL_PRICE =
            Target.the("precio total").located(By.id("totalp"));
}
