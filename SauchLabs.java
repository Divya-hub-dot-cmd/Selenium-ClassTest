package week1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingAutomation {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='user-name']"))).sendKeys("standard_user");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='password']"))).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='login-button']"))).click();

        WebElement secondProductName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[@class='inventory_item_name'])[2]")
                ));
        System.out.println(secondProductName.getText());

        WebElement secondProductPriceElement = driver.findElement(
                By.xpath("(//div[@class='inventory_item_name'])[2]" +
                        "//ancestor::div[@class='inventory_item']" +
                        "//following::div[@class='inventory_item_price'][1]")
        );

        double inventoryPrice = Double.parseDouble(
                secondProductPriceElement.getText().replace("$", "")
        );
        System.out.println(inventoryPrice);

        driver.findElement(
                By.xpath("(//div[@class='inventory_item_name'])[2]" +
                        "//ancestor::div[@class='inventory_item']//button")
        ).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='shopping_cart_link']"))).click();

        WebElement cartPriceElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='inventory_item_price']")
                ));

        double cartPrice = Double.parseDouble(
                cartPriceElement.getText().replace("$", "")
        );

        System.out.println(cartPrice == inventoryPrice);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='CHECKOUT']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='first-name']"))).sendKeys("Dhivya");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='last-name']"))).sendKeys("Velumani");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='postal-code']"))).sendKeys("600001");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type='submit']"))).click();

        List<WebElement> priceElements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[@class='inventory_item_price']")
                )
        );

        List<Double> prices = new ArrayList<>();

        for (WebElement price : priceElements) {
            prices.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        Collections.sort(prices);
        System.out.println(prices.get(prices.size() - 2));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='FINISH']"))).click();

        driver.quit();
    }
}


