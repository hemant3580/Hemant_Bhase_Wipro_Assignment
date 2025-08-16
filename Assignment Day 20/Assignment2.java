package AssignmentDay20;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://demoqa.com/select-menu");
    	driver.manage().window().maximize();
        Thread.sleep(2000);

        // single 
        WebElement select = driver.findElement(By.id("oldSelectMenu"));
        Select s = new Select(select);
        s.selectByVisibleText("Yellow");
        s.selectByIndex(0);
        
        // multi select 
        WebElement multiSelect = driver.findElement(By.id("react-select-4-input"));
        multiSelect.sendKeys("Blue");
        multiSelect.sendKeys(Keys.ENTER);

        multiSelect.sendKeys("Black");
        multiSelect.sendKeys(Keys.ENTER);

        Thread.sleep(6000);
        driver.quit();
    }
}
