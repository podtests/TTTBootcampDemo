package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TTTBootcamp {

    static ChromeOptions chromeOptions;
    static WebDriver wd;

    public static void main(String[] args) throws MalformedURLException {

        chromeOptions = new ChromeOptions();
        wd = new RemoteWebDriver( new URL("http://localhost:4444/"), chromeOptions);

        //Login
        wd.get("https://demo.evershop.io/account/login");
        wd.findElement(By.name("email")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.name("password")).sendKeys("Password");
        wd.findElement(By.xpath("//button[@type='submit']")).click();

        //Home Page:
        wd.findElement(By.xpath("//div[@class='listing-tem']//a/span[text()='^^']")).click();

        //Item Page:
        wd.findElement(By.xpath("//input[@name='qty']")).clear();
        wd.findElement(By.xpath("//input[@name='qty']")).sendKeys("2");
            //size
            wd.findElement(By.xpath( "(//ul[contains(@class, 'variant-option-list')])[1]/li/a[text()='^^']")).click();

            //color:
            wd.findElement(By.xpath( "(//ul[contains(@class, 'variant-option-list')])[2]/li/a[text()='^^']")).click();





    }
}
