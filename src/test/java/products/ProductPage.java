package products;

import login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {


    By basketButton = By.id("basket");
    By categoriesButton = By.id("categories");
    By logoutButton = By.id("logout");
    By ordersButton = By.id("orders");
    By productsButton = By.id("products");
    By addToBasketButton = By.id("addToBasketButton");
    By productText = By.id("productText");
    By categoryText = By.id("categoryText");
    By priceText = By.id("priceText");
    By descriptionText = By.id("descriptionText");
    By backendMessage = By.id("message");
    LoginPage loginPage ;
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void clickOrderButton(){
        WebElement registerButton = getOrdersButtonElement();
        registerButton.click();
    }


    public void clickAddToBasketButton(){
        WebElement addToBasketButtonElement = getAddToBasketButtonElement();
        addToBasketButtonElement.click();
    }

    public void clickLogoutButton(){
        WebElement registerButton = getLogoutButtonElement();
        registerButton.click();
    }

    public void clickCategoriesButton(){
        WebElement registerButton = getCategoriesButtonElement();
        registerButton.click();
    }

    public void clickBasketButton(){
        WebElement registerButton = getBasketButtonElement();
        registerButton.click();
    }

    public void clickProductButton(){
        WebElement registerButton = getProductsButtonElement();
        registerButton.click();
    }


    public WebElement getBasketButtonElement() {
        return driver.findElement(basketButton);
    }

    public WebElement getProductTextElement() {
        return driver.findElement(productText);
    }

    public WebElement getDescriptionTextElement() {
        return driver.findElement(descriptionText);
    }

    public WebElement getPriceTextElement() {
        return driver.findElement(priceText);
    }

    public WebElement getCategoryTextElement() {
        return driver.findElement(categoryText);
    }

    public WebElement getCategoriesButtonElement() {
        return driver.findElement(categoriesButton);
    }

    public WebElement getLogoutButtonElement() {
        return driver.findElement(logoutButton);
    }

    public WebElement getOrdersButtonElement() {
        return driver.findElement(ordersButton);
    }

    public WebElement getAddToBasketButtonElement() {
        return driver.findElement(addToBasketButton);
    }

    public WebElement getProductsButtonElement() {
        return driver.findElement(productsButton);
    }

    public boolean basketButtonElementIsEnable(){
        return driver.findElement(basketButton).isEnabled();
    }

    public boolean addToBasketButtonElementIsEnable(){
        return driver.findElement(addToBasketButton).isEnabled();
    }

    public boolean categoriesButtonElementIsEnable(){
        return driver.findElement(categoriesButton).isEnabled();
    }

    public boolean ordersButtonElementIsEnable(){
        return driver.findElement(ordersButton).isEnabled();
    }

    public boolean productTextElementIsEnable(){
        return driver.findElement(productText).isEnabled();
    }


    public boolean priceTextElementIsEnable(){
        return driver.findElement(priceText).isEnabled();
    }

    public boolean logoutButtonElementIsEnable(){
        return driver.findElement(logoutButton).isEnabled();
    }

    public boolean productsButtonElementIsEnable(){
        return driver.findElement(productsButton).isEnabled();
    }

    public boolean categoryTextElementIsEnable(){
        return driver.findElement(categoryText).isEnabled();
    }

    public boolean descriptionTextElementIsEnable(){
        return driver.findElement(descriptionText).isEnabled();
    }

    public boolean backendMessageElementIsEnable(){
        return driver.findElement(backendMessage).isEnabled();
    }

    public String getBackendMessage() {
        WebElement backendMessage = getBackendMessageElement();
        return backendMessage.getText();
    }

    public WebElement getBackendMessageElement() {
        return driver.findElement(backendMessage);
    }

}
