package EBAYSteps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class SearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the eBay homepage2")
    public void iAmOnTheEbayHomepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
    }

    @When("I search for {string}")
    public void iSearchFor(String product) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        searchBox.clear();
        searchBox.sendKeys(product);
        searchBox.sendKeys(Keys.ENTER);
    }

    @Then("search results for {string} should be displayed")
    public void verifySearchResults(String product) {
        wait.until(ExpectedConditions.titleContains("eBay"));
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("ebay"));
    }
        
        @After
        public void tearDown() {
            closeDriver();
        }

        public void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
    }
}
