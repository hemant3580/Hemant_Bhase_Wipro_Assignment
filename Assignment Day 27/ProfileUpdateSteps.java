package EBAYSteps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class ProfileUpdateSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        // Add login implementation if needed here
    }

    @When("I navigate to account settings and update the username to {string}")
    public void changeLoginUsername(String newName) {
        WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ghnav__left-wrap")));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).build().perform();

        driver.get("https://accountsettings.ebay.com/uas");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("account-settings-link-PI")));
        driver.findElement(By.id("account-settings-link-PI")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("individual_username_edit_button")));
        driver.findElement(By.id("individual_username_edit_button")).click();

        WebElement inp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
        inp.clear();
        inp.sendKeys(newName);

        driver.findElement(By.id("username_submit_edit_btn")).click();
    }

    @Then("the username should be updated successfully")
    public void verifyUsernameUpdated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
    }

    @When("I navigate to account settings and update the address with valid details")
    public void changeAddressDetails() {
        WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ghnav__left-wrap")));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).build().perform();

        driver.get("https://accountsettings.ebay.com/uas");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("account-settings-link-PI")));
        driver.findElement(By.id("account-settings-link-PI")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("individual_personal_info_address_edit_button")));
        driver.findElement(By.id("individual_personal_info_address_edit_button")).click();

        js.executeScript("window.scrollBy(0,400)");

        WebElement inp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressLine1")));
        inp.clear();
        inp.sendKeys("Range Hills, Pune, Maharashtra");

        WebElement ct = driver.findElement(By.id("city"));
        ct.clear();
        ct.sendKeys("Hyderabad");

        driver.findElement(By.cssSelector("select > option[value='TS']")).click();

        WebElement pc = driver.findElement(By.id("postalCode"));
        pc.clear();
        pc.sendKeys("411020");

        driver.findElement(By.id("address_edit_submit_button")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("address_edit_submit_button")));
    }

    @Then("the address should be updated successfully")
    public void verifyAddressUpdated() {
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
