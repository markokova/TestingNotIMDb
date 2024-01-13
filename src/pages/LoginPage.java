import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    By emailTextBox = By.name("email");

    public void insertEmail(String email){
        driver.findElement(emailTextBox).sendKeys(email);
    }

    public void insertPassword(String password){
        WebElement passwordTextBox = driver.findElement(By.name("password"));
        passwordTextBox.sendKeys(password);
        passwordTextBox.submit();
    }
}
