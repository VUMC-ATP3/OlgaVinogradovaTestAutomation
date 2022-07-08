package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public WebDriver driver;

    public InventoryPage(WebDriver driver) { //generate constructor
        this.driver = driver;
    }

    private By pageTitle = By.cssSelector("span[class='title']");

    public WebElement getPageTitle() {
        return driver.findElement(pageTitle);

    }

}
