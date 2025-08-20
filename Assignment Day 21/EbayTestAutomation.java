package Testing_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class EbayTestAutomation {

    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(7000);
    }

    // login
    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("userid")).sendKeys("bhasehem@gmail.com");
        driver.findElement(By.id("signin-continue-btn")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("pass")).sendKeys("Hemant@1311");
        driver.findElement(By.id("sgnBt")).click();
        Thread.sleep(7000);

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("ebay"));
    }

    // multiple search 
    @Test(priority = 2)
    public void multipleSearchesTest() throws InterruptedException {
        List<String> searchItems = new ArrayList<>();
        searchItems.add("laptop");
        searchItems.add("headphones");
        searchItems.add("camera");

        for (String item : searchItems) {
            WebElement searchBox = driver.findElement(By.id("gh-ac"));
            searchBox.clear();
            searchBox.sendKeys(item);
            searchBox.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            Assert.assertTrue(driver.getTitle().toLowerCase().contains(item));
            driver.navigate().back();
            Thread.sleep(2000);
        }
    }
    // add to cart
    @Test(priority = 3)
    public void addtocart() throws InterruptedException {
        driver.findElement(By.id("gh-logo")).click();
        Thread.sleep(3000);

        WebElement ns = driver.findElement(By.id("gh-ac"));
        ns.clear();
        ns.sendKeys("Bulova 97B168 Marine Star Blue Dial Rubber Strap Men's");
        ns.sendKeys(Keys.ENTER);
        Thread.sleep(4000);

        driver.findElement(By.cssSelector("img[alt=\"Bulova 97B168 Marine Star Blue Dial Rubber Strap Men's Chronograph Quartz Watch\"]")).click();
        Thread.sleep(6000);

       
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        // add to cart
        driver.findElement(By.id("atcBtn_btn_1")).click();
        Thread.sleep(7000);

        // close
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,-400)");
        driver.findElement(By.id("gh-logo")).click();
        Thread.sleep(3000);

       // remove
        driver.findElement(By.cssSelector("span[class=\"gh-cart__icon\"]")).click();
        driver.findElement(By.cssSelector("button[data-test-id=\"cart-removeitem\"]")).click();

        //home
        driver.findElement(By.id("gh-logo")).click();
        Thread.sleep(3000);
    }
    
    //change login name
   @Test(priority=4)
    public void changeloginname() throws InterruptedException {
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
    WebElement inp=driver.findElement(By.id("user_name"));
    inp.clear();
    inp.sendKeys("Hemant");
    driver.findElement(By.id("username_submit_edit_btn")).click();
    Thread.sleep(5000);
    WebElement name=driver.findElement(By.id("userid"));
    name.sendKeys("bhasehem0@gmail.com");
    driver.findElement(By.id("signin-continue-btn")).click();
    Thread.sleep(3000);
    WebElement pass=driver.findElement(By.id("pass"));
    pass.sendKeys("Hemant@1311");
    driver.findElement(By.id("sgnBt")).click();
    Thread.sleep(4000);
    }
    
   
   //change address
   @Test(priority=5)
   public void changeaddress() throws InterruptedException {
   WebElement elementToHover = driver.findElement(By.cssSelector("div[class=\"ghnav__left-wrap\"]"));
   Actions actions = new Actions(driver);
   actions.moveToElement(elementToHover).build().perform();
   Thread.sleep(3000);
   driver.get("https://accountsettings.ebay.com/uas");
   Thread.sleep(3000);
   driver.findElement(By.id("account-settings-link-PI")).click();
   Thread.sleep(3000);
   JavascriptExecutor js=(JavascriptExecutor)driver;
   js.executeScript("window.scrollBy(0,400)");
   driver.findElement(By.id("individual_personal_info_address_edit_button")).click();
   Thread.sleep(3000);
   js.executeScript("window.scrollBy(0,400)");
   WebElement inp=driver.findElement(By.id("addressLine1"));
   inp.clear();
   inp.sendKeys("Range Hills, Pune, Maharashtra");
   WebElement ct=driver.findElement(By.id("city"));
   ct.clear();
   ct.sendKeys("Hyderabad");
   driver.findElement(By.cssSelector("select>option[value=\"TS\"]"));
   WebElement pc=driver.findElement(By.id("postalCode"));
   pc.clear();
   pc.sendKeys("411020");
   driver.findElement(By.id("address_edit_submit_button")).click();
   Thread.sleep(5000);
   }
   
    //shop by category
    @Test (priority=6)
    public void shopbycategory() throws InterruptedException{
    driver.findElement(By.cssSelector("button[aria-controls=\"s0-1-4-12-0-1-dialog\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("a[_sp=\"m570.l3410\"]")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/section[2]/section/div/ul/li[3]/span/a")).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/section[1]/div/nav/ul/li[1]/a")
    ).click();
    Thread.sleep(3000);
    }
    
    //shop by all category
    @Test (priority=7)
    public void shopbycategoryall() throws InterruptedException{
    driver.findElement(By.cssSelector("select>option[value=\"12576\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("gh-search-btn")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/section[1]/div/nav/ul/li[1]/a")
    ).click();
    Thread.sleep(3000);
    }

    //@AfterMethod
    //public void postCondition() {
        //driver.manage().deleteAllCookies();
   // }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
