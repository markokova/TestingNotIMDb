import org.apache.commons.lang.time.DurationFormatUtils;
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

public class LoginTest {

    public WebDriver webDriver;
    public String loginURL = "http://localhost:3000/login";

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to(loginURL);
    }

    @Test
    public void loginTest() throws InterruptedException {
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.insertEmail("jozo@gmail.com");
        loginPage.insertPassword("jozo123");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        WebElement logedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title_watchlist")));

        Assert.assertEquals(logedInElement.getText(), "Watchlist");
    }

    @AfterMethod
    public void teardownTest(){
        webDriver.quit();
    }


}
