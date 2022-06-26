package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    public WebDriver driver;
    public LoginPage loginPage;

    @Before
    public void setup()  {
        System.setProperty("webdriver.chrome.driver", "C:\\private\\seleniumTests\\webdriver\\chromedriver.exe");
        System.setProperty("url", "http://localhost:3000");
        driver = new ChromeDriver();
        driver.navigate().to(System.getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkTitle() {
        Assert.assertEquals("MajkiSportShop", driver.getTitle());
    }


    @Test
    public void elementsAreEnabled() {
        Assert.assertTrue(driver.findElement(loginPage.email).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.password).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.signInButton).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.registerButton).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.signInText).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.githubLogin).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.googleLogin).isEnabled());
    }

    @Test
    public void googleTextIsCorrect(){
        Assert.assertEquals("Log in with Google", driver.findElement(loginPage.googleLogin).getText());
    }

    @Test
    public void githubTextIsCorrect(){
        Assert.assertEquals("Log in with Github", driver.findElement(loginPage.githubLogin).getText());
    }

    @Test
    public void emailIsEmpty() {
        Assert.assertTrue(driver.findElement(loginPage.password).isEnabled());
        WebElement password = driver.findElement(loginPage.password);
        password.sendKeys("myPassword");
        Assert.assertTrue(driver.findElement(loginPage.signInButton).isEnabled());
        driver.findElement(loginPage.signInButton).click();
        WebElement backendMessage = driver.findElement(loginPage.backendMessage);
        Assert.assertTrue(backendMessage.isEnabled());
        Assert.assertEquals("Email is empty!", backendMessage.getText());
    }


    @Test
    public void loginDataIsEmpty() {
        Assert.assertTrue(driver.findElement(loginPage.signInButton).isEnabled());
        driver.findElement(loginPage.signInButton).click();
        WebElement backendMessage = driver.findElement(loginPage.backendMessage);
        Assert.assertTrue(backendMessage.isEnabled());
        Assert.assertEquals("Email and Password are empty!", backendMessage.getText());
    }


    @Test
    public void passwordIsEmpty() {
        Assert.assertTrue(driver.findElement(loginPage.email).isEnabled());
        WebElement email = driver.findElement(loginPage.email);
        email.sendKeys("testowy@gmail.com");
        Assert.assertTrue(driver.findElement(loginPage.signInButton).isEnabled());
        driver.findElement(loginPage.signInButton).click();
        WebElement backendMessage = driver.findElement(loginPage.backendMessage);
        Assert.assertTrue(backendMessage.isEnabled());
        Assert.assertEquals("Password is empty!", backendMessage.getText());
    }

    @Test
    public void userDoesNotExist() throws InterruptedException {
        Assert.assertTrue(driver.findElement(loginPage.email).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.password).isEnabled());
        WebElement email = driver.findElement(loginPage.email);
        email.sendKeys("testowalny@gmail.com");
        WebElement password = driver.findElement(loginPage.password);
        password.sendKeys("password");
        driver.findElement(loginPage.signInButton).click();
        WebElement backendMessage = driver.findElement(loginPage.backendMessage);
        Assert.assertTrue(backendMessage.isEnabled());
        Thread.sleep(3000);
        Assert.assertEquals("User does not exist.", backendMessage.getText());
    }

    @Test
    public void loginCorrectUser() throws InterruptedException {
        Assert.assertTrue(driver.findElement(loginPage.email).isEnabled());
        Assert.assertTrue(driver.findElement(loginPage.password).isEnabled());
        WebElement email = driver.findElement(loginPage.email);
        email.sendKeys("testowy@gmail.com");
        WebElement password = driver.findElement(loginPage.password);
        password.sendKeys("testPassword");
        driver.findElement(loginPage.signInButton).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", System.getProperty("url"), "/product"), currentUrl);
    }



    @After
    public void clean() {
        driver.close();
        driver.quit();
    }
}
