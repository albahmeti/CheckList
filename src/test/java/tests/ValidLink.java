package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import static utilities.Driver.getDriver;

public class ValidLink {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }


    @Test
    public void ValidL() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/en/");
        Thread.sleep(2000);


        List<WebElement> listL=driver.findElements(By.tagName("a"));

        for (int i = 0; i < listL.size(); i++) {
            String urL = listL.get(i).getAttribute("href");

            try {
                if (urL.startsWith("https://") && (urL.contains(".com") || urL.contains(".dev"))) {
                    System.out.println(urL + " is valid");
                } else {
                    System.out.println(urL + " is NOT valid");
                }
            } catch(NullPointerException e){
                System.out.println("Not a link");
            }
        }

    }


    @AfterMethod
    public void end(){
        driver.close();
    }
}
