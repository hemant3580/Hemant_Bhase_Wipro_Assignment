package AssignmentDay24;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment1 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);
    }
    // login
    @Test(priority = 1)
    public void loginTest() {
        driver.findElement(By.linkText("Sign in")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        driver.findElement(By.id("userid")).sendKeys("bhasehem@gmail.com");
        driver.findElement(By.id("signin-continue-btn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        driver.findElement(By.id("pass")).sendKeys("Hemant@1311");
        driver.findElement(By.id("sgnBt")).click();

        wait.until(ExpectedConditions.titleContains("eBay"));
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("ebay"));
    }

    // multiple search 
    @Test(priority = 2)
    public void multipleSearchesTest() {
        List<String> searchItems = new ArrayList<>();
        searchItems.add("laptop");
        searchItems.add("headphones");
        searchItems.add("camera");

        for (String item : searchItems) {
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
            searchBox.clear();
            searchBox.sendKeys(item);
            searchBox.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.titleContains(item));
            Assert.assertTrue(driver.getTitle().toLowerCase().contains(item));

            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        }
    }

    // add to cart
    @Test(priority = 3)
    public void addtocart() throws InterruptedException {
        driver.findElement(By.id("gh-logo")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));

        WebElement ns = driver.findElement(By.id("gh-ac"));
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

        //Thread.sleep(5000);  

        driver.close();

        driver.switchTo().window(tabs.get(0));
        js.executeScript("window.scrollBy(0,-400)");

        driver.findElement(By.id("gh-logo")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.gh-cart__icon")));

        driver.findElement(By.cssSelector("span.gh-cart__icon")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test-id='cart-removeitem']")));
        driver.findElement(By.cssSelector("button[data-test-id='cart-removeitem']")).click();

        driver.findElement(By.id("gh-logo")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
    }

    // login name change - enabled false (so it will no get executed )
    @Test(enabled = false, priority = 1)
    public void changeLoginName() throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("userid")).sendKeys("bhasehem@gmail.com");
        driver.findElement(By.id("signin-continue-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pass")).sendKeys("Hemant@1311");
        driver.findElement(By.id("sgnBt")).click();
        Thread.sleep(3000);
        WebElement elementToHover = driver.findElement(By.cssSelector("div[class=\"ghnav__left-wrap\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(3000);
        driver.get("https://accountsettings.ebay.com/uas");
        Thread.sleep(3000);
        driver.findElement(By.id("account-settings-link-PI")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("individual_username_edit_button")).click();
        Thread.sleep(3000);
        WebElement inp = driver.findElement(By.id("user_name"));
        inp.clear();
        inp.sendKeys("Hemant_Updated");
        driver.findElement(By.id("username_submit_edit_btn")).click();
        Thread.sleep(5000);
        System.out.println("Change Login Name Test - ENABLED - Executed Successfully");
        Assert.assertTrue(driver.getCurrentUrl().contains("ebay"));
    }
    // change address - enabled false (so it will no get executed )
    @Test(enabled = false, priority = 2)
    public void changeAddress() throws InterruptedException {
        WebElement elementToHover = driver.findElement(By.cssSelector("div[class=\"ghnav__left-wrap\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(3000);
        driver.get("https://accountsettings.ebay.com/uas");
        Thread.sleep(3000);
        driver.findElement(By.id("account-settings-link-PI")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.id("individual_personal_info_address_edit_button")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,400)");
        WebElement inp = driver.findElement(By.id("addressLine1"));
        inp.clear();
        inp.sendKeys("Range Hills, Pune, Maharashtra");
        WebElement ct = driver.findElement(By.id("city"));
        ct.clear();
        ct.sendKeys("Hyderabad");
        System.out.println("Change Address Test - DISABLED - This will NOT execute");
        Assert.assertTrue(driver.getCurrentUrl().contains("ebay"));
    }
 // shop by category
    @Test(priority = 6)
    public void shopbycategory() {
        driver.findElement(By.cssSelector("button[aria-controls='s0-1-4-12-0-1-dialog']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[_sp='m570.l3410']")));
        driver.findElement(By.cssSelector("a[_sp='m570.l3410']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/section[2]/section/div/ul/li[3]/span/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/section[2]/section/div/ul/li[3]/span/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/section[1]/div/nav/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/section[1]/div/nav/ul/li[1]/a")).click();
    }

    // shop by all category
    @Test(priority = 7)
    public void shopbycategoryall() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select > option[value='12576']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-search-btn"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/section[1]/div/nav/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/section[1]/div/nav/ul/li[1]/a")).click();
    }
    //@AfterMethod
    //public void postCondition() {
        // driver.manage().deleteAllCookies();
   // }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
