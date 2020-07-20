package com.vytrack.base;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.vytrack.utilities.Driver.getD;
public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;



    @BeforeTest
    public void setUpTest() {
       ConfigurationReader.get("browser");
    }

    @AfterTest
    public void tearDownTest() {

    }


    @BeforeMethod
    public void setUpMethod() {


    }

    @AfterMethod
    public void tearDownMethod(){

    }

}
