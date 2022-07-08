package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By finishButton = By.id("finish");
    private By checkoutPageTitle = By.cssSelector("span[class='title']");

    private By backHomeButton = By.id("back-to-products");

    public void CheckoutSuccessPage() {
        getFinishButton().click();
    }

    public void BackHomeButton() {
        getBackHomeButton().click();
    }
    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButton);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }



    public WebElement getCheckoutPageTitle() {
        return driver.findElement(checkoutPageTitle);

    }
}