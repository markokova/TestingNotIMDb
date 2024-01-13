import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {

    public WebDriver driver;
    public String homeURL = "http://localhost:3000";
    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(homeURL);
    }

    @Test
    public void registerTest(){
        HomePage homePage = new HomePage(driver);
        homePage.registerUser("testFirstName", "testLastName", "testEmail", "testPassword", "12222002");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement homePageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome-title")));

        Assert.assertEquals(homePageTitle.getText(), "Welcome to NotIMDb!");
    }

    @AfterMethod
    public void teardownTest(){
        driver.quit();
    }
}
