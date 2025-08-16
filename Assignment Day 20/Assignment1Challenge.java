package AssignmentDay20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1Challenge {
 public static void main(String[] args) throws InterruptedException {
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://demoqa.com/dragabble");
     Actions actions = new Actions(driver);

     WebElement dragEl = driver.findElement(By.id("dragBox"));
     actions.dragAndDropBy(dragEl, 100, 100).perform();
     Thread.sleep(2000); 
     driver.quit();
 }
}
