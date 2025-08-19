package AssignmentDay24;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Assignment2 {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);
    }
    // it will run three times 
    @Test(invocationCount = 3)
    public void multipleSearchTest() throws InterruptedException {
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
            System.out.println("Searching for: " + item + " - Execution Count");
            Assert.assertTrue(driver.getTitle().toLowerCase().contains(item));
            driver.navigate().back();
            Thread.sleep(2000);
        }
        System.out.println("Multiple Search Test completed - This will run 3 times");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
