package AssignmentDay24;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Assignment6 {

    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void ebay() throws InterruptedException {
        System.out.println("Thread ID for ebay test: " + Thread.currentThread().getId());

        driver.get("https://www.ebay.com/");
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "eBay URL mismatch");
    }

    @Test(priority = 2)
    public void amazon() throws InterruptedException {
        System.out.println("Thread ID for amazon test: " + Thread.currentThread().getId());

        driver.get("https://www.amazon.in/");
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.in/";
        Assert.assertEquals(actualUrl, expectedUrl, "Amazon URL mismatch");
    }

    @Test(priority = 3)
    public void flipkart() throws InterruptedException {
        System.out.println("Thread ID for flipkart test: " + Thread.currentThread().getId());

        driver.get("https://www.flipkart.com/");
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.flipkart.com/";
        Assert.assertTrue(actualUrl.contains("flipkart"), "Flipkart URL mismatch");
    }

    @Test(priority = 4)
    public void zerobank() throws InterruptedException {
        System.out.println("Thread ID for zerobank test: " + Thread.currentThread().getId());

        driver.get("http://zero.webappsecurity.com/");
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "ZeroBank URL mismatch");
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
