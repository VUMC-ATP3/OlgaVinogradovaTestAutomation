package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ProductsPage;
import pageObjectsHomework.*;

public class SauceDemoTests {


    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod
            (alwaysRun = true)

    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();}

    //1. Scenārijs

@Test
    public void testSuccessfulLogin(){
        driver.get(SWAGLABS_URL);
        pageObjectsHomework.LoginPage loginPage = new pageObjectsHomework.LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
}

@Test
public void testCart()  {
    driver.get(SWAGLABS_URL);
    pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user","secret_sauce");
    WebElement addSauceLabsBikeLight = driver.findElement
            (By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    addSauceLabsBikeLight.click();
    CartPage cartPage = new CartPage(driver);
    cartPage.CartPage();
    Assert.assertEquals(CartPage.getItemName().getText(),"Sauce Labs Bike Light");}

@Test
public void testCheckout()  {
    driver.get(SWAGLABS_URL);
    pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user","secret_sauce");
    WebElement addSauceLabsBikeLight = driver.findElement
            (By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    addSauceLabsBikeLight.click();
    CartPage cartPage = new CartPage(driver);
    cartPage.CartPage();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    checkoutPage.CheckoutPage();
    checkoutPage.checkoutData("Olga","Vinogradova","LV-3602");}

    @Test
    public void testCheckoutOverview()  {
    driver.get(SWAGLABS_URL);
    pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user","secret_sauce");
    WebElement addSauceLabsBikeLight = driver.findElement
                (By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    addSauceLabsBikeLight.click();
    CartPage cartPage = new CartPage(driver);
    cartPage.CartPage();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    checkoutPage.CheckoutPage();
    checkoutPage.checkoutData("Olga","Vinogradova","LV-3602");
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    checkoutOverviewPage.CheckoutOverviewPage();
    Assert.assertEquals(CheckoutOverviewPage.getItemName().getText(),"Sauce Labs Bike Light");}

    @Test
    public void testCheckoutSuccessPage()  {
    driver.get(SWAGLABS_URL);
    pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user","secret_sauce");
    WebElement addSauceLabsBikeLight = driver.findElement
                    (By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    addSauceLabsBikeLight.click();
    CartPage cartPage = new CartPage(driver);
    cartPage.CartPage();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    checkoutPage.CheckoutPage();
    checkoutPage.checkoutData("Olga","Vinogradova","LV-3602");
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    checkoutOverviewPage.CheckoutOverviewPage();
    CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
    checkoutSuccessPage.CheckoutSuccessPage();
    Assert.assertEquals(checkoutSuccessPage.getCheckoutPageTitle().getText(),"CHECKOUT: COMPLETE!");
    checkoutSuccessPage.BackHomeButton();}


//2. Scenārijs

@Test
public void testCheckoutInfoErrorMessageWOFirstName() {
    driver.get(SWAGLABS_URL);
    pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    CartPage cartPage = new CartPage(driver);
    cartPage.CartPage();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    checkoutPage.CheckoutPage();
    checkoutPage.checkoutData("","Vinogradova","LV-3602");
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    checkoutOverviewPage.CheckoutOverviewPage();
    String actualText = checkoutPage.getCheckoutInfoErrorMessage().getText();
    String expectedErrorMessage = "Error: First Name is required";
    Assert.assertEquals(actualText,expectedErrorMessage);}

    @Test
    public void testCheckoutInfoErrorMessageWOLastName() {
    driver.get(SWAGLABS_URL);
    pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    CartPage cartPage = new CartPage(driver);
    cartPage.CartPage();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    checkoutPage.CheckoutPage();
    checkoutPage.checkoutData("Olga","","LV-3602");
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    checkoutOverviewPage.CheckoutOverviewPage();
    String actualText = checkoutPage.getCheckoutInfoErrorMessage().getText();
    String expectedErrorMessage = "Error: Last Name is required";
    Assert.assertEquals(actualText,expectedErrorMessage);}

    @Test
    public void testCheckoutInfoErrorMessageWOPostalCode() {
    driver.get(SWAGLABS_URL);
    pageObjectsHomework.LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    CartPage cartPage = new CartPage(driver);
    cartPage.CartPage();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    checkoutPage.CheckoutPage();
    checkoutPage.checkoutData("Olga","Vinogradova","");
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    checkoutOverviewPage.CheckoutOverviewPage();
    String actualText = checkoutPage.getCheckoutInfoErrorMessage().getText();
    String expectedErrorMessage = "Error: Postal Code is required";
    Assert.assertEquals(actualText,expectedErrorMessage);
}


@AfterMethod
    public void closeBrowser(){
        driver.quit();
}


}
