package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utilities.Driver.getDriver;

public class OlympicsTest1 {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }


    @Test
    public void DefaultTest() throws InterruptedException {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        Thread.sleep(2000);

        List<WebElement> table = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]/tbody/tr/td[1]"));




    }


    @AfterMethod
    public void end(){
        driver.close();
    }

}
