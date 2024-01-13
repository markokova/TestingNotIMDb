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

public class LogoutTest {

    public WebDriver driver;
    public HomePage homePage;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        homePage.login("jozo@gmail.com", "jozo123");
    }

    @Test
    public void logoutTest(){
        HomePage homePage = new HomePage(driver);
        homePage.logoutUser();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logedOutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        Assert.assertEquals(logedOutElement.getText(), "Log In");
    }

    @AfterMethod
    public void teardownTest(){
        driver.quit();
    }
}
