package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShop.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcodemyShopTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
//        SafariOptions browserOptions = new SafariOptions();
//        browserOptions.setPlatformName("macOS 12");
//        browserOptions.setBrowserVersion("15");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("build", "<your build id>");
//        sauceOptions.put("name", "<your test name>");
//        browserOptions.setCapability("sauce:options", sauceOptions);

//        URL url = new URL("https://OlgaVi:81012e0a-2d90-4831-a433-8ef880b8985b@ondemand.us-west-1.saucelabs.com:443/wd/hub");
//        driver = new RemoteWebDriver(url, browserOptions);
        ChromeOptions options = new ChromeOptions();
        //EdgeOptions options = new EdgeOptions();
        driver = new RemoteWebDriver(new URL("http://192.168.1.108:4444"), options);

        //driver = new ChromeDriver();
driver.manage().window().maximize();
wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
@Test
public void testSearch() throws InterruptedException {
    driver.get("http://shop.acodemy.lv/");
    Thread.sleep(5000);
    MainPage mainPage = new MainPage(driver);
//    mainPage.getSearchInputField().sendKeys("Beanie");
//
//    Actions actions =new Actions(driver);
//    actions.sendKeys(Keys.ENTER).perform(); //nospiest Enter
//    Thread.sleep(5000);
//    mainPage.getSearchInputField().clear();
//    mainPage.getSearchInputField().sendKeys("t-shirt");
//    actions.sendKeys(Keys.ENTER).perform(); //nospiest Enter
//    Thread.sleep(5000);
    mainPage.searchProduct("Beanie");

    Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 2 results");

    mainPage.searchProduct("T-shirt");

    Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 3 results");
//2.variants ka parbaudit
    mainPage.searchProduct("Hoodie");
    Assert.assertEquals(mainPage.getSearchResults().size(),3);
//    List<WebElement> results =  mainPage.getSearchResults();
//    for (int i = 0; i < results.size(); i++) {
//        System.out.println("##########################");
//        System.out.println(results.get(i).getText());
//    }
    List<WebElement> results =  mainPage.getSearchResults();
    for (int i = 0; i < results.size(); i++) {
        System.out.println("##########################");
        System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
    }}
    @Test
    public void testEmptySearch()  {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("OlgaOlgaa");
        Assert.assertEquals(mainPage.getNoSearchResultText(),MainPage.NO_SEARCH_RESULTS);
    }

    @Test public void testSwitchTabs(){
        driver.get("http://shop.acodemy.lv/");
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());//dabu visas logas kas ir atverti
        driver.switchTo().window(tabs.get(1)); //parsledzas uz otro tabu. pirmais ir otrs tabs(jaunais). 0 - ir pirmais tabs. skaitisana sakas no "0"
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        driver.close(); //aizvers pirmo tabu
        tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); //parsledz uz otro tabu
        System.out.println(driver.getTitle());
    }

@Test
public void testJavascript () throws InterruptedException {
    driver.get("http://shop.acodemy.lv/");
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
    Thread.sleep(5000);
//    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
//    Thread.sleep(5000);
//    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
//    Thread.sleep(5000);
//    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
//    Thread.sleep(5000);
//    ((JavascriptExecutor) driver).executeScript("alert('OlgaOlga')");
    WebElement element = driver.findElement(By.cssSelector("li.post-18"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    Thread.sleep(4000);
    }

    @Test
    public void mouseActionsTest() throws InterruptedException {

        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(3000);

    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform();
        Thread.sleep(5000);
    }



@AfterMethod
    public void tearDownBrowser(){
driver.quit();
}

}
