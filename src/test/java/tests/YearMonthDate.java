package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


import static utilities.Driver.getDriver;

public class YearMonthDate {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }

    @Test
    public void yearMonthDay() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(2000);

        List <WebElement> dropDown1 = driver.findElements(By.xpath("//*[@id=\"year\"]/option"));
        WebElement dropDown =driver.findElement(By.id("year"));
        //int i = dropDown.size();


        Random rand = new Random();

        Select y = new Select(dropDown);
        int list= rand.nextInt(dropDown1.size());
        dropDown1.get(list).click();
        WebElement viti = y.getFirstSelectedOption();
        String viti1 = viti.getAttribute("value");
        int a = new Integer(viti1);


        Thread.sleep(1000);

        WebElement month=driver.findElement(By.id("month"));

        //List <WebElement> teposht = driver.findElements(By.id("month"));
        Select m= new Select(month);
        for(int j = 0; j < 12 ; j++)
        {
            m.selectByIndex(j);
            WebElement muji1 = m.getFirstSelectedOption();
            String muji = muji1.getText();
            Thread.sleep(500);
            List <WebElement> days31 = driver.findElements(By.xpath("//*[@id=\"day\"]/option"));
            int d = days31.size();
            if(j<7)
            {
                if (j == 1)
                {
                    if(a%4==0 && d == 29)
                    {
                        System.out.println(muji + " has " + d + " days and it is a LEAP YEAR");
                    }
                    else if (a%4 == 1 && d == 28)
                    {
                        System.out.println(muji + " has " + d + " days.");
                    }
                    else
                    {
                        System.out.println(muji + " has FAILED");
                    }
                    continue;

                }
                if(j%2 == 0 && d == 31)
                {
                    System.out.println(muji + " has " + d + " days.");
                }
                else if ( j%2 == 1 && d == 30)
                {
                    System.out.println(muji + " has " + d + " days.");
                }
                else {
                    System.out.println(muji + " has FAILED");
                }

            }
            if (j>=7)
            {
                if(j%2 == 1 && d == 31)
                {
                    System.out.println(muji + " has " + d + " days.");
                }
                else if ( j%2 == 0 && d == 30)
                {
                    System.out.println(muji + " has " + d + " days.");
                }
                else {
                    System.out.println(muji + " has FAILED");
                }
            }
        }


//        List <WebElement> days31 = driver.findElements(By.xpath("//*[@id=\"day\"]/option"));
//        int d = dropDown.size();






        Thread.sleep(2000);

    }

    @AfterMethod
    public void end(){
        driver.close();
    }


}
