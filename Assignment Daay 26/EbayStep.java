package cucumberTest;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EbayStep {
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
        driver.findElement(By.linkText("Sign in")).click();
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

    @Given("I am on the eBay homepage")
    public void iAmOnTheEbayHomepage() {
        if (driver == null) {
            openEbayHomepage();
        }
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
        wait.until(ExpectedConditions.titleContains(product));
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(product));
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
    }

    @Given("I am logged in")
    public void loggedIn() {
        openEbayHomepage();
        clickSignIn();
        enterValidUsernameAndPassword();
        verifyLoggedIn();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-logo")));
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
        ct.sendKeys("Pune");

        driver.findElement(By.cssSelector("select > option[value='MH']")).click();

        WebElement pc = driver.findElement(By.id("postalCode"));
        pc.clear();
        pc.sendKeys("411020");

        driver.findElement(By.id("address_edit_submit_button")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("address_edit_submit_button")));
    }

    @Then("the address should be updated successfully")
    public void verifyAddressUpdated() {
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
    }
}


