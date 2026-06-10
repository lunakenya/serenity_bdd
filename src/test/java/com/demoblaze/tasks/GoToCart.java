package com.demoblaze.tasks;

import com.demoblaze.userinterfaces.CartPage;
import com.demoblaze.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Task para navegar al carrito de compras.
 *
 * <p>Después de hacer clic en Cart, Demoblaze carga los ítems del carrito
 * de forma asíncrona desde su API. Se requiere esperar explícitamente a que
 * al menos una fila ({@code #tbodyid tr}) sea visible antes de continuar,
 * ya que el botón "Place Order" aparece aunque el carrito esté vacío.</p>
 */
@Subject("va al carrito de compras")
public class GoToCart implements Task {

    private static final Logger log = LoggerFactory.getLogger(GoToCart.class);
    private static final int CART_ITEMS_TIMEOUT = 15;

    /**
     * Factory method para crear el Task de forma legible.
     *
     * @return instancia instrumentada de GoToCart
     */
    public static GoToCart page() {
        return Tasks.instrumented(GoToCart.class);
    }

    @Override
    @Step("{0} navega al carrito de compras")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.CART_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.CART_LINK),
                WaitUntil.the(CartPage.PLACE_ORDER_BUTTON, isVisible()).forNoMoreThan(15).seconds()
        );

        // El carrito carga sus ítems asincrónicamente desde la API de Demoblaze.
        // Esperamos hasta que al menos una fila aparezca en la tabla del carrito.
        waitForCartItemsToLoad(actor);
    }

    /**
     * Espera activamente a que los ítems del carrito se carguen en el DOM.
     * Demoblaze hace una llamada API para obtener los ítems después de que la
     * página carga, por lo que es necesario un wait explícito.
     */
    private <T extends Actor> void waitForCartItemsToLoad(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CART_ITEMS_TIMEOUT));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#tbodyid tr td")
            ));
            log.debug("Ítems del carrito cargados correctamente.");
        } catch (Exception e) {
            log.warn("No se detectaron ítems en el carrito tras {} segundos. " +
                    "El carrito puede estar vacío o la carga fue muy lenta.", CART_ITEMS_TIMEOUT);
        }
    }
}
