package EBAYSteps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I open the eBay homepage")
    public void openEbayHomepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
    }

    @When("I click on Sign in")
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in"))).click();
    }

    @When("I enter valid username and password")
    public void enterValidUsernameAndPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        driver.findElement(By.id("userid")).sendKeys("bhasehem@gmail.com");
        driver.findElement(By.id("signin-continue-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        driver.findElement(By.id("pass")).sendKeys("Hemant@1311");
        driver.findElement(By.id("sgnBt")).click();
    }

    @Then("I should be logged in successfully")
    public void verifyLoggedIn() {
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
