import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminDashboard {

    public WebDriver driver;
    public WebDriverWait wait;

    public AdminDashboard(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By deleteMovieButtonId = By.id("Delete");
    By movieTitleId = By.id("movie-title");

    public void deleteMovie(int movieIndex){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteMovieButtonId));

        List<WebElement> deleteMovieButtons = driver.findElements(deleteMovieButtonId);

        //wait max 5 seconds for deleteMovieButton to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(deleteMovieButtonId));

        deleteMovieButtons.get(movieIndex).click();
    }

    public String getMovieTitleByIndex(int movieIndex){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitleId));

        List<WebElement> movieTitles = driver.findElements(movieTitleId);
        return movieTitles.get(movieIndex).getText();
    }
}
