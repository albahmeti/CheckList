package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static utilities.Driver.getDriver;

public class Cart {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
    }


    @Test
    public void CartTest() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.className("nav-input")).click();

        List<WebElement> r = driver.findElements(By.xpath("//h2//a//span"));
        Random random = new Random();

        int randNum = random.nextInt(r.size() - 1);

        String whole = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[" + (randNum + 1) + "]")).getText();
        String fraction = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[" + (randNum + 1) + "]")).getText();
        String price = "$" + whole + "." + fraction;
        String header = r.get(randNum).getText();

        r.get(randNum).click();
        Thread.sleep(2000);

        WebElement quantity = driver.findElement(By.className("a-dropdown-prompt"));

        if (quantity.getText().equals("1")) {
            System.out.println("PASS - it is 1");
        } else {
            System.out.println("FAIL - it is: " + quantity.getText());
        }

        Thread.sleep(2000);

        String nextHeader = driver.findElement(By.id("productTitle")).getText();
        String nextPrice = driver.findElement(By.id("price_inside_buybox")).getText();

        if (nextHeader.equals(header) && nextPrice.equals(price)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected: " + nextHeader);
            System.out.println("Expected: " + nextPrice);
            System.out.println("Actual: " + header);
            System.out.println("Actual: " + price);
        }
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));

        if (addToCart.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL - element not visible");
        }
    }



    @AfterMethod
    public void end(){
        driver.close();
    }
}
