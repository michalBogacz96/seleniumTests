package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    By email = By.id("email");
    By password = By.id("password");
    By signInButton = By.id("signInButton");
    By registerButton = By.id("registerButton");
    By signInText = By.id("signInText");
    By backendMessage = By.id("message");
    By googleLogin = By.id("googleLogin");
    By githubLogin = By.id("githubLogin");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void signIn(String emailToWrite, String passwordToWrite) {
        WebElement myEmail = driver.findElement(email);
        myEmail.sendKeys(emailToWrite);
        WebElement myPassword = driver.findElement(password);
        myPassword.sendKeys(passwordToWrite);
        driver.findElement(signInButton).click();
    }


}