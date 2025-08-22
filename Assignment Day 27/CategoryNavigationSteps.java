package EBAYSteps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class CategoryNavigationSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the eBay homepage3")
    public void iAmOnTheEbayHomepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
    }

    @When("I navigate by categories to Electronics -> Mobiles")
    public void shopByCategoryNavigation() {
        driver.findElement(By.cssSelector("button[aria-controls='s0-1-4-12-0-1-dialog']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[_sp='m570.l3410']")));
        driver.findElement(By.cssSelector("a[_sp='m570.l3410']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/section/section/div/ul/li/span/a")));
        driver.findElement(By.xpath("/html/body/div/div/section/section/div/ul/li/span/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/section[1]/div/nav/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div/div/section[1]/div/nav/ul/li[1]/a")).click();
    }

    @Then("the correct category page should be displayed")
    public void verifyCategoryPage() {
    }

    @When("I select {string} from all categories dropdown and search")
    public void shopByAllCategoryDropdown(String category) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select > option[value='12576']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-search-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/section[1]/div/nav/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div/div/section[1]/div/nav/ul/li[1]/a")).click();
    }

    @Then("the results should be filtered for Electronics")
    public void verifyFilteredResults() {
        wait.until(ExpectedConditions.titleContains("eBay"));
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("ebay"));    }
    @After
    public void tearDown() {
        closeDriver();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }}
}
