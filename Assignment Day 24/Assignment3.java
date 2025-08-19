package AssignmentDay24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment3 {
    WebDriver driver;
    // add required for testng.xml
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);
    }
    // add required for testng.xml

    @Parameters({"username", "password"})
    @Test
    public void loginTest(String username, String password) throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("userid")).sendKeys(username);
        driver.findElement(By.id("signin-continue-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("sgnBt")).click();
        Thread.sleep(3000);
        System.out.println("Login with Username: " + username + ", Password: " + password);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("ebay"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
