package homework20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    String baseUrl = "http://store.demoqa.com";
    ExcelToArrayReader reader = new ExcelToArrayReader();
    String [][] data;

    @Test
    public void loginPositive() throws InterruptedException {
        data = reader.readToArray(1,1);
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        WebElement myAccountLink = driver.findElement(By.className("account_icon"));
        myAccountLink.click();
        WebElement usernameField = driver.findElement(By.id("log"));
        usernameField.clear();
        usernameField.sendKeys(data[0][0]);
        WebElement passwordField = driver.findElement(By.id("pwd"));
        passwordField.clear();
        passwordField.sendKeys(data[0][1]);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        WebElement userName = (new WebDriverWait(driver, 7))
                        .until(ExpectedConditions
                        .presenceOfElementLocated(By.className("display-name")));
        assert userName.getText().equals(data[0][2]);

    }


    @Test
    public void loginNegative() throws InterruptedException {
        data = reader.readToArray(2,2);
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        WebElement myAccountLink = driver.findElement(By.className("account_icon"));
        myAccountLink.click();
        WebElement usernameField = driver.findElement(By.id("log"));
        usernameField.clear();
        usernameField.sendKeys(data[0][0]);
        WebElement passwordField = driver.findElement(By.id("pwd"));
        passwordField.clear();
        passwordField.sendKeys(data[0][1]);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        WebElement message = (new WebDriverWait(driver, 7))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.className("response")));
        assert message.getText().equals(data[0][2]);

    }


}
