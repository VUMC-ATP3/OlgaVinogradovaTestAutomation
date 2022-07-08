package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public static WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    private By checkoutPage = By.id("checkout");
    private By checkoutInfoErrorMessage = By.cssSelector("h3[data-test='error']");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");


    public void CheckoutPage(){
        getCheckoutPage().click();
    }



    public void checkoutData(String firstName,String lastName,String postalCode){
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getPostalCodeField().sendKeys(postalCode);
    }
    public WebElement getCheckoutPage(){
        return driver.findElement(checkoutPage);
    }
    public WebElement getFirstNameField(){
        return driver.findElement(firstNameField);
    }
    public WebElement getLastNameField(){
        return driver.findElement(lastNameField);
    }
    public WebElement getPostalCodeField(){
        return driver.findElement(postalCodeField);
    }
    public WebElement getCheckoutInfoErrorMessage(){return driver.findElement(checkoutInfoErrorMessage);}

}
