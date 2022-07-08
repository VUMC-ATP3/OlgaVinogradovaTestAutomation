package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public static WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    private By cartPage = By.className("shopping_cart_link");
    private static By itemName = By.id("item_0_title_link");

    public void CartPage(){
        getCartPage().click();
    }

    public WebElement getCartPage(){
        return driver.findElement(cartPage);
    }



    public static WebElement getItemName() {
        return driver.findElement(itemName);

    }

}
