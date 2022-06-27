package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTitle {
WebDriver chromeBrowser;

    @Test
    public void testWebTitleOne(){
        chromeBrowser.navigate().to("https://www.airbaltic.com");
        chromeBrowser.manage().window().maximize();
        String expectedTitle = "Oficiālā airBaltic vietne | Lēti lidojumi no " +
                "Rīgas uz Eiropu, Skandināviju, Tuvajiem Austrumiem";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void testWebTitleTwo(){
        chromeBrowser.navigate().to ("https://www.delfi.lv");
        chromeBrowser.manage().window().maximize();
        String expectedTitle = "DELFI - Vadošais ziņu portāls Latvijā - DELFI";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @BeforeMethod
    public void openBrowser(){
        this.chromeBrowser = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser(){
        chromeBrowser.quit();
    }
}
