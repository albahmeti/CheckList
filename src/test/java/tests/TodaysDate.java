package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.LocalDate;

import java.time.format.DateTimeFormatter;


import static utilities.Driver.*;

public class TodaysDate {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }

    @Test
    public void today() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(2000);

        WebElement year=driver.findElement(By.id("year"));
        Select y= new Select(year);
        String viti=y.getFirstSelectedOption().getText();

        WebElement month=driver.findElement(By.id("month"));
        Select m= new Select(month);
        String muji=m.getFirstSelectedOption().getText();

        WebElement day=driver.findElement(By.id("day"));
        Select d= new Select(day);
        String dita=d.getFirstSelectedOption().getText();
        String da=dita+"/"+muji+"/"+viti;

        LocalDate date = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MMMM/uuuu");

        String dmv= date.format(format);

        if (da.equals(dmv)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expected ="+dmv);
            System.out.println("actual ="+da);
        }

        driver.close();

        }

    }

