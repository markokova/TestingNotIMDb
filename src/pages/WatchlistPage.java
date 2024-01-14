import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WatchlistPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public WatchlistPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By movieCardId = By.className("movie-card");
    By homeButtonId = By.id("app_name");

    public int countMoviesInWatchlist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieCardId));
        List<WebElement> movieCards = driver.findElements(movieCardId);

        return movieCards.size();
    }

    public void goToHomePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeButtonId));
        driver.findElement(homeButtonId).click();
    }
}
