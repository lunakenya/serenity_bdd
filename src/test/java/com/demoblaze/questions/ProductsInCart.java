package com.demoblaze.questions;

import com.demoblaze.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Question que retorna la lista de nombres de productos actualmente en el carrito.
 *
 * <p>Itera sobre las filas de la tabla del carrito y extrae los textos de
 * la segunda columna (nombre del producto), ignorando filas vacías.</p>
 */
@Subject("los productos en el carrito")
public class ProductsInCart implements Question<List<String>> {

    /**
     * Factory method para usar la Question con actor.asksFor().
     *
     * @return instancia de ProductsInCart
     */
    public static ProductsInCart displayed() {
        return new ProductsInCart();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        List<WebElement> rows = BrowseTheWeb.as(actor)
                .getDriver()
                .findElements(By.cssSelector("#tbodyid tr"));

        return rows.stream()
                .map(row -> {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    return cells.size() > 1 ? cells.get(1).getText().trim() : "";
                })
                .filter(text -> !text.isBlank())
                .collect(Collectors.toList());
    }
}
