package in.podtest;

import in.podtest.pom.HomePOM;
import in.podtest.pom.ItemPOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TTTBootcamp {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
         ChromeOptions chromeOptions;
         WebDriver wd;

        chromeOptions = new ChromeOptions();
        //wd = new RemoteWebDriver( new URL("http://localhost:4444/"), chromeOptions);
        wd = new ChromeDriver();
        LoginPOM login = new LoginPOM(wd);
        HomePOM home = new HomePOM(wd);
        ItemPOM item = new ItemPOM(wd);

        login.get().fillCredentials("akhiljda@gmail.com", "Password").clickLogin(); //homepage

        home.clickItem("Nike air zoom pegasus 35"); //itemPage

        item.fillQuantity("2").selectSize("L").selectColor("Green");

        Thread.sleep(4000);

        item.clickAddToCart();




    }
}
