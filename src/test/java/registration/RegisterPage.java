package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {


    By email = By.id("email");
    By emailText = By.id("emailText");
    By password = By.id("password");
    By passwordText = By.id("passwordText");
    By firstname = By.id("firstname");
    By firstnameText = By.id("firstNameText");
    By lastname = By.id("lastname");
    By lastnameText = By.id("lastNameText");
    By registerNewAccountButton = By.id("registerNewAccountButton");
    By signInButton = By.id("signInButton");
    By signInText = By.id("signInText");
    By createNewAccountText = By.id("createNewAccountText");
    By backendMessage = By.id("message");
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean emailElementIsEnable(){
        return driver.findElement(email).isEnabled();
    }

    public boolean emailTextElementIsEnable(){
        return driver.findElement(emailText).isEnabled();
    }

    public boolean passwordTextElementIsEnable(){
        return driver.findElement(passwordText).isEnabled();
    }

    public boolean firstNameTextElementIsEnable(){
        return driver.findElement(firstnameText).isEnabled();
    }


    public boolean lastNameTextElementIsEnable(){
        return driver.findElement(lastnameText).isEnabled();
    }

    public boolean passwordElementIsEnable(){
        return driver.findElement(password).isEnabled();
    }

    public boolean firstNameElementIsEnable(){
        return driver.findElement(firstname).isEnabled();
    }

    public boolean lastNameElementIsEnable(){
        return driver.findElement(lastname).isEnabled();
    }

    public boolean registerButtonElementIsEnable(){
        return driver.findElement(registerNewAccountButton).isEnabled();
    }

    public boolean backendMessageElementIsEnable(){
        return driver.findElement(backendMessage).isEnabled();
    }

    public boolean createNewAccountTextElementIsEnable(){
        return driver.findElement(createNewAccountText).isEnabled();
    }

    public void clickSignInButton(){
        WebElement signInButton = getSignInButtonElement();
        signInButton.click();
    }

    public void clickSignInText(){
        WebElement signInText = getSignInTextElement();
        signInText.click();
    }

    public boolean signInButtonElementIsEnable(){
        return driver.findElement(signInButton).isEnabled();
    }

    public boolean signInTextElementIsEnable(){
        return driver.findElement(signInText).isEnabled();
    }

    public String getBackendMessage() {
        WebElement backendMessage = getBackendMessageElement();
        return backendMessage.getText();
    }

    public void registerNewUser(String email, String password){
        fillInTheFirstName("firstName");
        fillInThePassword(password);
        fillInTheEmail(email);
        clickRegisterButton();
    }



    public void clickRegisterButton(){
        WebElement registerButton = getRegisterButtonElement();
        registerButton.click();
    }

    public WebElement fillInThePassword(String newPassword){
        WebElement password = getPasswordElement();
        password.sendKeys(newPassword);
        return password;
    }

    public WebElement fillInTheEmail(String newEmail){
        WebElement email = getEmailElement();
        email.sendKeys(newEmail);
        return email;
    }

    public WebElement fillInTheFirstName(String newFirstName){
        WebElement firstName = getFirstNameElement();
        firstName.sendKeys(newFirstName);
        return firstName;
    }

    public WebElement fillInTheLastName(String newLastName){
        WebElement lastName = getLastNameElement();
        lastName.sendKeys(newLastName);
        return lastName;
    }

    public WebElement getBackendMessageElement() {
        return driver.findElement(backendMessage);
    }


    public WebElement getFirstNameElement() {
        return driver.findElement(firstname);
    }

    public WebElement getRegisterButtonElement() {
        return driver.findElement(registerNewAccountButton);
    }

    public WebElement getSignInButtonElement() {
        return driver.findElement(signInButton);
    }

    public WebElement getFirstNameTextElement() {
        return driver.findElement(firstnameText);
    }

    public WebElement getLastNameTextElement() {
        return driver.findElement(lastnameText);
    }

    public WebElement getEmailTextElement() {
        return driver.findElement(emailText);
    }

    public WebElement getPasswordTextElement() {
        return driver.findElement(passwordText);
    }

    public WebElement getSignInTextElement() {
        return driver.findElement(signInText);
    }

    public WebElement getLastNameElement() {
        return driver.findElement(lastname);
    }

    public WebElement getPasswordElement() {
        return driver.findElement(password);
    }

    public WebElement getEmailElement() {
        return driver.findElement(email);
    }
}
