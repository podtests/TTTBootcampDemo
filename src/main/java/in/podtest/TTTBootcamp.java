package in.podtest;

import in.podtest.pom.HomePOM;
import in.podtest.pom.ItemPOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TTTBootcamp {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
         ChromeOptions chromeOptions;
         WebDriver wd;

        chromeOptions = new ChromeOptions();
        //wd = new RemoteWebDriver( new URL("http://localhost:4444/"), chromeOptions);
        wd = new ChromeDriver();
        FluentWait wait = new FluentWait(wd);
            wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);


        LoginPOM login = new LoginPOM(wd);
        HomePOM home = new HomePOM(wd);
        ItemPOM item = new ItemPOM(wd);

        login.get().fillCredentials("akhiljda@gmail.com", "Password").clickLogin(); //homepage

        // Adding Wait mechanism
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='listing-tem']//a/span[text()='Nike air zoom pegasus 35']")));

        home.clickItem("Nike air zoom pegasus 35"); //itemPage

        item.fillQuantity("2").selectSize("L").selectColor("Green");

        Thread.sleep(4000);

        item.clickAddToCart();

    }
}
