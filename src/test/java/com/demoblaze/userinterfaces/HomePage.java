package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Selectores de la página principal (Home) de Demoblaze.
 * Centraliza todos los localizadores para evitar duplicación.
 */
public class HomePage {

    private HomePage() {
        // Clase de constantes — no instanciar
    }

    /** Enlace "Home" en la barra de navegación */
    public static final Target HOME_LINK =
            Target.the("enlace Home").located(By.id("nava"));

    /** Enlace "Cart" en la barra de navegación */
    public static final Target CART_LINK =
            Target.the("enlace Carrito").located(By.id("cartur"));

    /** Lista de productos en el catálogo */
    public static final Target PRODUCT_LIST =
            Target.the("lista de productos").located(By.id("tbodyid"));

    /**
     * Retorna el Target de un producto del catálogo por su nombre visible.
     *
     * @param productName nombre del producto tal como aparece en la página
     * @return Target del enlace del producto
     */
    public static Target productNamed(String productName) {
        return Target.the("producto '" + productName + "'")
                .located(By.xpath("//a[normalize-space(text())='" + productName + "']"));
    }

    /** Spinner de carga del catálogo de productos */
    public static final Target LOADING_SPINNER =
            Target.the("spinner de carga").located(By.id("loading"));
}
