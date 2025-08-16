package AssignmentDay20;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://demoqa.com/alerts");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		WebElement seealert=driver.findElement(By.id("alertButton"));
		seealert.click();
		Thread.sleep(4000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(4000);
		
		WebElement timealert=driver.findElement(By.id("timerAlertButton"));
		timealert.click();
		Thread.sleep(6000);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
		Thread.sleep(3000);
		
		WebElement confirmalert=driver.findElement(By.id("confirmButton"));
		confirmalert.click();
		Thread.sleep(4000);
		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
		
		Thread.sleep(3000);
		
		WebElement promptalert=driver.findElement(By.id("promtButton"));
		promptalert.click();
		Thread.sleep(3000);
		Alert alert3=driver.switchTo().alert();
		alert3.sendKeys("NSD");
		alert3.accept();
		
		Thread.sleep(3000);
		driver.close();
	}

}