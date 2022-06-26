package products;

import login.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPageTest {


    public WebDriver driver;
    public ProductPage productPage;
    public LoginPage loginPage;


    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\private\\seleniumTests\\webdriver\\chromedriver.exe");
        System.setProperty("url", "http://localhost:3000");
        driver = new ChromeDriver();
        driver.navigate().to(System.getProperty("url"));
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.signIn("testowy@gmail.com", "testPassword");
        Thread.sleep(4000);
    }

    @Test
    public void urlIsCorrect() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", System.getProperty("url"), "/product"), currentUrl);
    }

    @Test
    public void elementsAreEnable() {
        Assert.assertTrue(productPage.basketButtonElementIsEnable());
        Assert.assertTrue(productPage.categoriesButtonElementIsEnable());
        Assert.assertTrue(productPage.logoutButtonElementIsEnable());
        Assert.assertTrue(productPage.ordersButtonElementIsEnable());
        Assert.assertTrue(productPage.productsButtonElementIsEnable());
        Assert.assertTrue(productPage.productTextElementIsEnable());
        Assert.assertTrue(productPage.categoryTextElementIsEnable());
        Assert.assertTrue(productPage.priceTextElementIsEnable());
        Assert.assertTrue(productPage.descriptionTextElementIsEnable());
        Assert.assertTrue(productPage.addToBasketButtonElementIsEnable());
        Assert.assertTrue(productPage.backendMessageElementIsEnable());
    }


    @Test
    public void clickAddToBasketAneVerifyMessage() {
        productPage.clickAddToBasketButton();
        Assert.assertEquals("Product added to basket", productPage.getBackendMessageElement().getText());
    }


    @Test
    public void productTextIsCorrect() {
        System.out.println(productPage.getProductTextElement().getText());
        Assert.assertTrue(productPage.getProductTextElement().getText().contains("Product:"));
    }

    @Test
    public void categoryTextIsCorrect() {
        Assert.assertTrue(productPage.getCategoryTextElement().getText().contains("Category:"));
    }

    @Test
    public void priceTextIsCorrect() {
        Assert.assertTrue(productPage.getPriceTextElement().getText().contains("Price:"));
    }

    @Test
    public void descriptionTextIsCorrect() {
        Assert.assertTrue(productPage.getDescriptionTextElement().getText().contains("Description:"));
    }


    @Test
    public void ulrIsCorrectAfterOrderButtonClick() {
        productPage.clickOrderButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", System.getProperty("url"), "/orders"), currentUrl);
    }

    @Test
    public void ulrIsCorrectAfterProductButtonClick() {
        productPage.clickProductButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", System.getProperty("url"), "/product"), currentUrl);
    }

    @Test
    public void ulrIsCorrectAfterCategoryButtonClick() {
        productPage.clickCategoriesButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", System.getProperty("url"), "/category"), currentUrl);
    }

    @Test
    public void ulrIsCorrectAfterBasketButtonClick() {
        productPage.clickBasketButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", System.getProperty("url"), "/basket"), currentUrl);
    }


    @Test
    public void ulrIsCorrectAfterLogoutButtonClick() {
        productPage.clickLogoutButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(String.format("%s%s", System.getProperty("url"), "/"), currentUrl);
    }





    @After
    public void clean() {
        driver.close();
        driver.quit();
    }

}
