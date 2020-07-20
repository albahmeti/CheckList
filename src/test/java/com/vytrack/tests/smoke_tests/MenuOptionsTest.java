package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.vytrack.utilities.Driver.getD;
public class MenuOptionsTest extends TestBase{
    public static WebDriver driver;

    @FindBy(name="prependedInput")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy (id = "_submit")
    public WebElement submit;

    @BeforeMethod
    public void setUp() {
        driver = getD(ConfigurationReader.get("url"));
    }


    @Test
    public void MenuTest() throws InterruptedException {
        String user=ConfigurationReader.get("driver_username");
        String passW=ConfigurationReader.get("driver_password");

        username.sendKeys(user);
        password.sendKeys(passW);
        submit.click();
    }




    @AfterMethod
    public void end(){
        driver.close();
    }
}
