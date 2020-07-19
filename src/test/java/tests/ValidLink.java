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
    public void ValidL() throws InterruptedException, MalformedURLException {
        driver.get("https://www.w3schools.com/");
        Thread.sleep(2000);

        String url="";
        int response=200;

        List<WebElement> listL=driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = listL.iterator();
        while (it.hasNext()){
            url=it.next().getAttribute("href");
//            System.out.println(url);

            if (url.isEmpty()){
                System.out.println("There is no link");
                continue;
            }

            try {
                HttpURLConnection linkV= (HttpURLConnection)(new URL(url).openConnection());
                linkV.setRequestMethod("HEAD");
                linkV.connect();

                response=linkV.getResponseCode();

                if(response>=400){
                    System.out.println(url+" is not valid");
                }else{
                    System.out.println(url+" is valid");
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

        }


//        for (WebElement element : listL) {
//            element.getAttribute("href");
//
//            if(!element.getAttribute("href").isEmpty()){
//                element.click();
//                driver.navigate().back();
//                System.out.println("The link is valid");
//
//            }else if(element.getAttribute("href").isEmpty()){
//                System.out.println("There is no link");
//            }
//
//        }
    }


    @AfterMethod
    public void end(){
        driver.close();
    }
}
