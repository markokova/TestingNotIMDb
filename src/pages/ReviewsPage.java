import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReviewsPage {

    public WebDriver driver;

    public ReviewsPage(WebDriver driver){
        this.driver = driver;
    }

    By reviewTitleId = By.id("review-title");

    public boolean isSuccessfulySubmited(String testReviewTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> reviewTitles = driver.findElements(reviewTitleId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewTitleId));

        for (WebElement reviewTitle : reviewTitles) {
            if(reviewTitle.getText().equals(testReviewTitle)){
                return true;
            }
        }
        return false;
    }
}
