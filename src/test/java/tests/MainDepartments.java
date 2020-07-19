package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.CollectionUtils;

import java.util.*;

import static utilities.Driver.getDriver;

public class MainDepartments {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }


    @Test
    public void DepSort() throws InterruptedException {
        driver.get("https://www.amazon.com/gp/site-directory");
        Thread.sleep(2000);

        List<WebElement> selectList = driver.findElements(By.className("fsdDeptTitle"));

        List<String> sL=new ArrayList<>();
        for (WebElement e : selectList) {
            sL.add(e.getText());
        }

        WebElement dropList = driver.findElement(By.id("searchDropdownBox"));
        Select d = new Select(dropList);

        List<String> dL = new ArrayList<>();
        for (WebElement e : d.getOptions()) {
            dL.add(e.getText());
        }




        Collections.sort(sL);
        Collections.sort(dL);



//        if(Arrays.asList(dL).contains(sL)){
//            System.out.println("The elements are the same");
//        }else{
//            System.out.println("Elements are missing");
//            System.out.println(sL);
//            System.out.println(dL);
//
//        }

        if(sL.retainAll(dL)){
            System.out.println("The elements are the same");
        }else{
            System.out.println("Elements are missing");
            System.out.println(sL);
            System.out.println(dL);
        }

    }


    @AfterMethod
    public void end(){
        driver.close();
    }

}
