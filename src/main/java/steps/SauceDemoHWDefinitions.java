package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjectsHomework.*;

import java.time.Duration;

public class SauceDemoHWDefinitions {
    WebDriver driver;
    pageObjectsHomework.LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;


    @Before("@chromeBrowser")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After("@chromeBrowser")
    public void tearDown(){
        driver.close();
    }


    @Given("user is navigating to {string}")
    public void user_is_navigating_to(String url) {
      driver.get(url);
    }
    @When("user enters correct username {string} and password {string}")
    public void user_enters_correct_username_and_password(String username, String password) {
     loginPage.getUsernameField().sendKeys(username);
     loginPage.getPasswordField().sendKeys(password);
    }
    @And("user clicks login button below")
    public void userClicksLoginButtonBelow() {
        loginPage.getLoginButton().click();
    }

    @Then("user is successfully logged in website")
    public void user_is_successfully_logged_in_website() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
    }


    @When("user add one product to cart")
    public void userAddOneProductToCart() {
        WebElement addSauceLabsBikeLight = driver.findElement
                (By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        addSauceLabsBikeLight.click();
    }

    @And("navigate to cart page")
    public void navigateToCartPage() {
        cartPage = new CartPage(driver);
        cartPage.getCartPage().click();
    }

    @Then("user can find added product on the cart page")
    public void userCanFindAddedProductOnTheCartPage() {
        Assert.assertEquals(CartPage.getItemName().getText(),"Sauce Labs Bike Light");
    }

    @When("user navigated to checkout")
    public void userNavigatedToCheckout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutPage().click();
    }

    @And("user enters first name {string}, last name {string} and Postal Code {string}")
    public void userEntersFirstNameOlgaLastNameVinogradovaAndPostalCodeLV(String firstName, String lastName, String postalCode) {
    checkoutPage.getFirstNameField().sendKeys(firstName);
    checkoutPage.getLastNameField().sendKeys(lastName);
    checkoutPage.getPostalCodeField().sendKeys(postalCode);
    }

    @And("user clicks continue button")
    public void userClicksContinueButton() {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.CheckoutOverviewPage();
    }

    @Then("user can find product on checkout overview page")
    public void userCanFindProductOnCheckoutOverviewPage() {
        Assert.assertEquals(CheckoutOverviewPage.getItemName().getText(),"Sauce Labs Bike Light");
    }

    @When("user clicks finish button")
    public void userClicksFinishButton() {
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
        checkoutSuccessPage.getFinishButton().click();
    }

    @Then("user can see on the website that checkout is sucessfully completed")
    public void userCanSeeOnTheWebsiteThatCheckoutIsSucessfullyCompleted() {
        Assert.assertEquals(checkoutSuccessPage.getCheckoutPageTitle().getText(), "CHECKOUT: COMPLETE!");
    }

    @And("user can click back home button")
    public void userCanClickBackHomeButton() {
        checkoutSuccessPage.getBackHomeButton().click();
    }

    @Then("user sees error text {string}")
    public void userSeesErrorTextError_text(String errorText) {
        Assert.assertEquals(checkoutPage.getCheckoutInfoErrorMessage().getText(),errorText);
    }
}
