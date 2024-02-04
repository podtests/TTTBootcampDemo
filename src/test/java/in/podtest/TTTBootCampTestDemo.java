package in.podtest;

import in.podtest.pom.HomePOM;
import in.podtest.pom.ItemPOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TTTBootCampTestDemo {

    WebDriverWait wait;
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;

    WebDriver wd;
    FluentWait fluentWait;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void BC(String browserName) throws MalformedURLException {
        System.out.println("Value of Browser is: "+ browserName);

        switch (browserName) {
            case "chrome": {
                chromeOptions = new ChromeOptions();
                //wd = new RemoteWebDriver( new URL("http://localhost:4444/"), chromeOptions);
                wd = new ChromeDriver();
                break;
            }
            case "firefox": {
                firefoxOptions = new FirefoxOptions();
                wd = new RemoteWebDriver( new URL("http://localhost:4444/"), firefoxOptions);
                break;
            }
            default: {
                chromeOptions = new ChromeOptions();
                wd = new RemoteWebDriver( new URL("http://localhost:4444/"), chromeOptions);
                break;
            }
        }

    }

    @Parameters({"Username", "Password", "ItemName"})
    @Test
    public void addItemToCartTest(String UN, String PW, String itemName) throws InterruptedException, MalformedURLException {

        LoginPOM login = new LoginPOM(wd);
        HomePOM home = new HomePOM(wd);
        ItemPOM item = new ItemPOM(wd);
        fluentWait = new FluentWait(wd);

        login.get().fillCredentials(UN, PW).clickLogin(); //homepage

        home.validatePage(fluentWait, itemName).clickItem(itemName); //itemPage

        Assert.assertEquals(item.getItemName().toLowerCase(), itemName.toLowerCase());  //hard assert

        item.fillQuantity("2").selectSize("L").selectColor("Green");

        String currenturl = wd.getCurrentUrl();
        
        System.out.println("URL is"+currenturl);

        Thread.sleep(4000);

        item.clickAddToCart();

    }
}
