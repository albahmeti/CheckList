package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static utilities.Driver.getDriver;

public class Links {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }


    @Test
    public void LinkTag() throws InterruptedException {
        driver.get("https://www.w3schools.com/");
        Thread.sleep(2000);

        List<WebElement> listElements=driver.findElements(By.tagName("a"));
        for (WebElement element : listElements) {


            if(element.isDisplayed()){
                System.out.println(element.getAttribute("href"));
                System.out.println(element.getAttribute("text"));
            }else {
                System.out.println("The element is not displayed");
            }
        }


    }


    @AfterMethod
    public void end(){
        driver.close();
    }
}
