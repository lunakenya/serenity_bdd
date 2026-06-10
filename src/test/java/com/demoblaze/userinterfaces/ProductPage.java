package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Selectores de la página de detalle de producto en Demoblaze.
 */
public class ProductPage {

    private ProductPage() {
        // Clase de constantes — no instanciar
    }

    /** Botón "Add to cart" en la página del producto */
    public static final Target ADD_TO_CART_BUTTON =
            Target.the("botón Agregar al carrito")
                    .located(By.xpath("//a[contains(text(),'Add to cart')]"));

    /** Nombre del producto en la página de detalle */
    public static final Target PRODUCT_NAME =
            Target.the("nombre del producto")
                    .located(By.className("name"));

    /** Precio del producto en la página de detalle */
    public static final Target PRODUCT_PRICE =
            Target.the("precio del producto")
                    .located(By.className("price-container"));
}
