package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utilities.Driver.getDriver;

public class DepartmentsSort {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }

    @Test
    public void DepSort() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        WebElement dropD =driver.findElement(By.id("searchDropdownBox"));
        Select dd= new Select(dropD);
        WebElement text = dd.getFirstSelectedOption();
        String elem = text.getText();
        if (elem.equals("All Departments")){
            System.out.println("First selected is ALL");
        }else{
            System.out.println("Fail");
        }


        WebElement el = driver.findElement(By.id("searchDropdownBox"));
        Select d = new Select(el);
        List<WebElement> oList5 = driver.findElements(By.xpath("//*[@id=\"searchDropdownBox\"]/option"));

        List<String> oList6 = new ArrayList<>();
        for (WebElement e : oList5) {
            oList6.add(e.getText());
        }

        List<String> oList = new ArrayList<>();
        for (WebElement e : d.getOptions()) {
            oList.add(e.getText());
        }


        Collections.sort(oList);
        int rez = 0;
//        System.out.println(tempList);
//        System.out.println(oList);
//        System.out.println(oList6);
        for(int i = 0; i<oList.size();i++)
        {
            String oList1 = oList6.get(i);
            String tList1 = oList.get(i);
            if(!oList1.equals(tList1)) {
                rez = 1;
                break;
            }
        }


        if(rez == 0){
            System.out.println("Elements are sorted");
        }else{
            System.out.println("Elements are not sorted");
        }

    }

    @AfterMethod
    public void end(){
        driver.close();
    }

}
