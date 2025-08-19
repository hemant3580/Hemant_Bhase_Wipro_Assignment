package AssignmentDay24;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
// used excel data to fetch username and password 
public class Assignment5 {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zero.webappsecurity.com/login.html");
        Thread.sleep(2000);
    }

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        String excelPath = "C:\\Users\\bhase\\eclipse-workspace\\TestNG_selenium_\\src\\test\\resources\\TestData.xlsx";
        String sheetName = "LoginData";
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows - 1][cols];
        for (int i = 1; i < rows; i++) { // skip header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = (cell == null) ? "" : cell.toString();
            }
        }
        workbook.close();
        fis.close();
        return data;
    }

    @Test(dataProvider = "excelData")
    public void zeroBankLoginTestWithExcelData(String username, String password, String status) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.clear();
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.clear();
        passwordField.sendKeys(password);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);

        System.out.println("ZeroBank Login - Username: " + username + ", Password: " + password + ", Expected Status: " + status);
        if (status.equalsIgnoreCase("valid")) {
            
            boolean loggedIn = driver.getCurrentUrl().contains("account-summary.html");
            if (!loggedIn) {
                
                boolean errorDisplayed = driver.findElements(By.cssSelector(".alert-error")).size() > 0;
                Assert.assertFalse(errorDisplayed, "Expected successful login but error was displayed.");
            }
            Assert.assertTrue(loggedIn, "Login should be successful for status=valid.");
        } else {
            boolean errorDisplayed = driver.findElements(By.cssSelector(".alert-error")).size() > 0;
            Assert.assertTrue(errorDisplayed, "Expected login to fail for status=invalid.");
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
