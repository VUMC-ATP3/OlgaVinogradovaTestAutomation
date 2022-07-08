package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    public static WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutOverviewPage = By.id("continue");

    public void CheckoutOverviewPage(){
        getCheckoutOverviewPage().click();
    }

    public WebElement getCheckoutOverviewPage(){
        return driver.findElement(checkoutOverviewPage);
    }

    private static By itemName = By.className("inventory_item_name");

    public static WebElement getItemName() {
        return driver.findElement(itemName);}

}
