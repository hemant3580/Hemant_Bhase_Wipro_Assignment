package AssignmentDay20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://demoqa.com/buttons");
		Thread.sleep(6000);
		driver.manage().window().maximize();
		
		WebElement doubleclick=driver.findElement(By.id("doubleClickBtn"));
		Actions act=new Actions(driver);
		act.doubleClick(doubleclick).perform();
		
		Thread.sleep(6000);
		WebElement rightclick=driver.findElement(By.id("rightClickBtn"));
		act.contextClick(rightclick).perform();
		
		Thread.sleep(6000);
		WebElement click=driver.findElement(By.id("9V5Ri"));
		act.contextClick(click).perform();
		driver.close();
		
		WebDriver driver2=new ChromeDriver();
		driver2.get("https://www.ebay.com/");
		driver2.manage().window().maximize();
		Actions act1=new Actions(driver2);
		
		WebElement motors=driver2.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));
		act1.moveToElement(motors).perform();
		Thread.sleep(3000);
		
		WebElement sports=driver2.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[7]/a"));
		act1.moveToElement(sports).perform();
		Thread.sleep(3000);
		
		WebElement fashion=driver2.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[5]/a"));
		act1.moveToElement(fashion).perform();
		Thread.sleep(3000);
		driver2.close();	
		
		
		WebDriver driver3=new ChromeDriver();	
		driver3.get("https://demoqa.com/droppable");
		driver3.manage().window().maximize();
		Actions act2=new Actions(driver3);
		WebElement source=driver3.findElement(By.id("draggable"));
		WebElement target=driver3.findElement(By.id("droppable"));
		act2.dragAndDrop(source, target).perform();
		driver3.close();
	}

}