import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToWatchlistTest {

    public WebDriver driver;
    public String homeURL = "http://localhost:3000";
    public HomePage homePage;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(homeURL);
        //precondition: user is loged in
        homePage = new HomePage(driver);
        homePage.login("jozo@gmail.com","jozo123");
    }

    @Test
    public void addToWatchlistTest(){
        WatchlistPage watchlistPage = new WatchlistPage(driver);

        homePage.goToWatchlistPage();
        int numOfMoviesBeforeAdding = watchlistPage.countMoviesInWatchlist();
        watchlistPage.goToHomePage();
        homePage.addMovieToWatchlist(0);
        homePage.goToWatchlistPage();
        int numOfMoviesAfterAdding = watchlistPage.countMoviesInWatchlist();

        Assert.assertNotEquals(numOfMoviesBeforeAdding, numOfMoviesAfterAdding);
    }

    @AfterMethod
    public void teardownTest(){
        driver.quit();
    }
}
