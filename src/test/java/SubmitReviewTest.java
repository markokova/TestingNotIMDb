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
import java.util.List;

public class SubmitReviewTest {

    public WebDriver driver;
    public String reviewsURL = "http://localhost:3000/68e4ccdf-0336-46b5-89ac-4dff995bd3c8/reviews";
    private String testReviewTitle = "TEST REVIEW TITLE";
    private String testReviewContent = "TEST REVIEW CONTENT";
    public HomePage homePage;


    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.login("jozo@gmail.com", "jozo123");
    }

    @Test
    public void submitReviewTest(){
        driver.manage().window().maximize();
        homePage.goToMovieDetails(0);

        //submit new review
        MovieDetailsPage movieDetailsPage = new MovieDetailsPage(driver);
        movieDetailsPage.submitReview(testReviewTitle, testReviewContent, "5");

        driver.navigate().to(reviewsURL);

        ReviewsPage reviewsPage = new ReviewsPage(driver);

        //check if review is successfully submitted
        Assert.assertTrue(reviewsPage.isSuccessfulySubmited(testReviewTitle));
    }

    @AfterMethod
    public void teardownTest(){
        driver.quit();
    }
}
