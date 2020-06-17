package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;
import java.util.Random;

import static utilities.Driver.*;

public class Days {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }

    @Test
    public void randomChecker() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(2000);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("td input"));
        List<WebElement> labels = driver.findElements(By.cssSelector("td label"));
        Random random = new Random();
        int counter = 0;
        while (counter != 3) {
            int rng = random.nextInt(checkboxes.size() - 1);
            if (checkboxes.get(rng).isEnabled()) {
                if (labels.get(rng).getText().equals("Friday")) {
                    counter++;
                }
                checkboxes.get(rng).click();
                System.out.println(labels.get(rng).getText());
                checkboxes.get(rng).click();
            }
        }

            driver.close();
    }
}

