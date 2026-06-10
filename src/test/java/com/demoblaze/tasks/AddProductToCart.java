package com.demoblaze.tasks;

import com.demoblaze.interactions.AcceptAlert;
import com.demoblaze.userinterfaces.HomePage;
import com.demoblaze.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Task que agrega un producto específico al carrito desde el catálogo.
 *
 * <p>Flujo:
 * 1. Hace clic en el producto por nombre en el catálogo.
 * 2. Espera a que el botón "Add to cart" sea visible.
 * 3. Hace clic en "Add to cart".
 * 4. Acepta el alert de confirmación "Product added".
 * </p>
 */
@Subject("agrega '#productName' al carrito")
public class AddProductToCart implements Task {

    private final String productName;

    public AddProductToCart(String productName) {
        this.productName = productName;
    }

    /**
     * Factory method para crear el Task de forma legible.
     *
     * @param productName nombre del producto tal como aparece en el catálogo
     * @return instancia instrumentada de AddProductToCart
     */
    public static AddProductToCart named(String productName) {
        return Tasks.instrumented(AddProductToCart.class, productName);
    }

    @Override
    @Step("{0} agrega el producto '#productName' al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.productNamed(productName), isVisible())
                        .forNoMoreThan(15).seconds(),
                Click.on(HomePage.productNamed(productName)),
                WaitUntil.the(ProductPage.ADD_TO_CART_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(ProductPage.ADD_TO_CART_BUTTON),
                AcceptAlert.thatAppearsAfterAddingToCart()
        );
    }
}
