package registration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class RegisterPageTest {

    public WebDriver driver;
    public RegisterPage registerPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\private\\seleniumTests\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        System.setProperty("url", "http://localhost:3000/registration");
        driver.navigate().to(System.getProperty("url"));
        registerPage = new RegisterPage(driver);
    }


    @Test
    public void elementsAreEnabled() {
        Assert.assertTrue(registerPage.emailElementIsEnable());
        Assert.assertTrue(registerPage.passwordElementIsEnable());
        Assert.assertTrue(registerPage.signInButtonElementIsEnable());
        Assert.assertTrue(registerPage.signInTextElementIsEnable());
        Assert.assertTrue(registerPage.firstNameElementIsEnable());
        Assert.assertTrue(registerPage.lastNameElementIsEnable());
        Assert.assertTrue(registerPage.registerButtonElementIsEnable());
        Assert.assertTrue(registerPage.createNewAccountTextElementIsEnable());
        Assert.assertTrue(registerPage.emailTextElementIsEnable());
        Assert.assertTrue(registerPage.passwordTextElementIsEnable());
        Assert.assertTrue(registerPage.firstNameTextElementIsEnable());
        Assert.assertTrue(registerPage.lastNameTextElementIsEnable());
    }

    @Test
    public void emailTextIsCorrect(){
        Assert.assertEquals("Email Address", registerPage.getEmailTextElement().getText());
    }

    @Test
    public void firstNameTextIsCorrect(){
        Assert.assertEquals("First Name", registerPage.getFirstNameTextElement().getText());
    }

    @Test
    public void lastNameTextIsCorrect(){
        Assert.assertEquals("Last Name", registerPage.getLastNameTextElement().getText());
    }

    @Test
    public void passwordTextIsCorrect(){
        Assert.assertEquals("Password", registerPage.getPasswordTextElement().getText());
    }


    @Test
    public void registerDataIsEmpty() {
        Assert.assertTrue(registerPage.registerButtonElementIsEnable());
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.backendMessageElementIsEnable());
        Assert.assertEquals("Data is empty.", registerPage.getBackendMessage());
    }

    @Test
    public void firstNameIsEmpty() {
        registerPage.fillInTheEmail("przypadkowy@gmail.com");
        registerPage.fillInThePassword("password");
        Assert.assertTrue(registerPage.registerButtonElementIsEnable());
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.backendMessageElementIsEnable());
        Assert.assertEquals("First Name is empty.", registerPage.getBackendMessage());
    }

    @Test
    public void emailIsEmpty() {
        registerPage.fillInTheFirstName("firstName");
        registerPage.fillInThePassword("password");
        Assert.assertTrue(registerPage.registerButtonElementIsEnable());
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.backendMessageElementIsEnable());
        Assert.assertEquals("Email is empty.", registerPage.getBackendMessage());
    }

    @Test
    public void passwordIsEmpty() {
        registerPage.fillInTheFirstName("firstName");
        registerPage.fillInTheEmail("przypadkowy@gmail.com");
        Assert.assertTrue(registerPage.registerButtonElementIsEnable());
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.backendMessageElementIsEnable());
        Assert.assertEquals("Password is empty.", registerPage.getBackendMessage());
    }

    @Test
    public void clickSignInButton() {
        Assert.assertTrue(registerPage.signInButtonElementIsEnable());
        registerPage.clickSignInButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", "http://localhost:3000", "/"), currentUrl);
    }

    @Test
    public void clickSignInText() {
        Assert.assertTrue(registerPage.signInTextElementIsEnable());
        registerPage.clickSignInText();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", "http://localhost:3000", "/"), currentUrl);
    }


    @Test
    public void registerNewUser() throws InterruptedException {
        String email = String.format("%s%d@gmail.com", "m", new Date().getTime());
        registerPage.registerNewUser(email, "testPassword");
        Assert.assertTrue(registerPage.backendMessageElementIsEnable());
        Thread.sleep(1000);
        Assert.assertEquals("User is registered.", registerPage.getBackendMessage());
    }

    @Test
    public void userExists() throws InterruptedException {
        registerPage.registerNewUser("testowy@gmail.com", "testPassword");
        Assert.assertTrue(registerPage.backendMessageElementIsEnable());
        Thread.sleep(1000);
        Assert.assertEquals("User with given email exists.", registerPage.getBackendMessage());
    }


    @After
    public void clean() {
        driver.close();
        driver.quit();
    }
}
