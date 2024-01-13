import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    public WebDriver driver;
    public String loginURL = "http://localhost:3000/login";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By userButtonId = By.id("btn-user-dropdown");
    By logoutButtonId = By.id("logout-button");
    By registerButtonId = By.id("register-button");
    By firstNameTextBoxId = By.id("firstName");
    By lastNameTextBoxId = By.id("lastName");
    By emailTextBoxId = By.id("email");
    By passwordTextBoxId = By.id("password");
    By dateOfBirthTextBoxId = By.id("dateOfBirth");
    By movieCard = By.className("movie-card");

    public void logoutUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement userButton = wait.until(ExpectedConditions.elementToBeClickable(userButtonId));
        userButton.click();
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutButtonId));
        logoutButton.click();
    }

    public void registerUser(String firstName, String lastName, String email, String password, String dateOfBirth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerButtonId));
        registerButton.click();

        //insert register data
        wait.until(ExpectedConditions.elementToBeClickable(firstNameTextBoxId)).sendKeys(firstName);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameTextBoxId)).sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(emailTextBoxId)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextBoxId)).sendKeys("password");

        WebElement dateOfBirthTextBox = wait.until(ExpectedConditions.elementToBeClickable(dateOfBirthTextBoxId));
        dateOfBirthTextBox.sendKeys(dateOfBirth);

        dateOfBirthTextBox.submit();
    }

    public void login(String email, String password){
        driver.navigate().to(loginURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertEmail(email);
        loginPage.insertPassword(password);
    }

    public void goToMovieDetails(int movieIndex){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieCard));
        List<WebElement> movies = driver.findElements(movieCard);
        movies.get(movieIndex).click();
    }
}
