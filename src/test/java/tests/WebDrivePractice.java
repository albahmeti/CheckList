package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.getDriver;

public class WebDrivePractice {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();



    }

    @Test
    public void Test1(){
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        WebElement warning=driver.findElement(By.xpath("//small[.='The date of birth is not valid']"));
        Assert.assertTrue(warning.isDisplayed());
    }


    @Test
    public void Test2() throws InterruptedException {

        List<WebElement> checkText=driver.findElements(By.className("form-check"));

        List<String> langSupposed=new ArrayList<>();
        langSupposed.add("C++");
        langSupposed.add("Java");
        langSupposed.add("JavaScript");


        for (WebElement e : checkText) {
            Assert.assertTrue(langSupposed.contains(e.getText()));
        }

    }

    @Test
    public void Test3(){
        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement warning=driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warning.isDisplayed());
    }

    @Test
    public void Test4(){
        driver.findElement(By.name("lastname")).sendKeys("q");
        WebElement warning=driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warning.isDisplayed());
    }

    @Test
    public void Test5(){

    }


    @AfterMethod
    public void end(){
        driver.close();
    }
}
