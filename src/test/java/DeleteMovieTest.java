import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteMovieTest {

    public WebDriver driver;
    int movieToDeleteIndex = 0;
    public HomePage homePage;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        homePage.login("uber@gmail.com","password");
        homePage.goToAdminDashboard();
    }

    @Test
    public void deleteMovieTest(){
        driver.manage().window().maximize();

        AdminDashboard adminDashboard = new AdminDashboard(driver);

        //fetch movie at the same index before and after deletion, if move titles are different deletion is successful
        String firstMovieBeforeDeleting = adminDashboard.getMovieTitleByIndex(movieToDeleteIndex);
        adminDashboard.deleteMovie(movieToDeleteIndex);
        driver.navigate().refresh();
        String firstMovieAfterDeleting = adminDashboard.getMovieTitleByIndex(movieToDeleteIndex);

        Assert.assertNotEquals(firstMovieBeforeDeleting, firstMovieAfterDeleting);
    }

    @AfterMethod
    public void teardownTest(){
        driver.quit();
    }
}
