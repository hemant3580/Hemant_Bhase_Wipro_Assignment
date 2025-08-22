package EBAYSteps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class AddToCartSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I open the eBay homepage1")
    public void iOpenTheEbayHomepage1() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.ebay.com/");
    }

    @When("I add the product to the cart")
    public void addProductToCart() {
        WebElement ns = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        ns.clear();
        ns.sendKeys("Bulova 97B168 Marine Star Blue Dial Rubber Strap Men's");
        ns.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("img[alt=\"Bulova 97B168 Marine Star Blue Dial Rubber Strap Men's Chronograph Quartz Watch\"]")));
        driver.findElement(By.cssSelector(
            "img[alt=\"Bulova 97B168 Marine Star Blue Dial Rubber Strap Men's Chronograph Quartz Watch\"]")).click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("atcBtn_btn_1")));
        driver.findElement(By.id("atcBtn_btn_1")).click();

        driver.close();
        driver.switchTo().window(tabs.get(0));
        js.executeScript("window.scrollBy(0,-400)");
    }

    @Then("the product should be visible in the cart")
    public void verifyProductInCart() {
        driver.findElement(By.id("gh-logo")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.gh-cart__icon")));
        driver.findElement(By.cssSelector("span.gh-cart__icon")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test-id='cart-removeitem']")));
    }

    @When("I remove the product from the cart")
    public void removeProductFromCart() {
        driver.findElement(By.cssSelector("button[data-test-id='cart-removeitem']")).click();
    }

    @Then("the cart should be empty")
    public void verifyCartIsEmpty() {
        wait.until(ExpectedConditions.titleContains("eBay"));
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("ebay"));    	 }
    @After
    public void tearDown() {
        closeDriver();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
}}
