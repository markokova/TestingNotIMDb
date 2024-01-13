import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MovieDetailsPage {

    public WebDriver driver;

    public MovieDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    By openModalButtonId = By.id("add-new-review-button");
    By titleTextBoxId = By.id("title");
    By contentTextBoxId = By.id("content");
    By scoreTextBoxId = By.id("score");
    By submitReviewButtonId = By.id("modal-add-review-button");

    public void submitReview(String title, String content, String score) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement openModalButton = wait.until(ExpectedConditions.elementToBeClickable(openModalButtonId));

        //force click button - to avoid ElementClickInterceptedException
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", openModalButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-card")));

        //input params in text boxes
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleTextBoxId)).sendKeys(title);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentTextBoxId)).sendKeys(content);
        wait.until(ExpectedConditions.visibilityOfElementLocated(scoreTextBoxId)).sendKeys(score);

        WebElement submitReviewButton = wait.until(ExpectedConditions.elementToBeClickable(submitReviewButtonId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitReviewButton);
    }
}
