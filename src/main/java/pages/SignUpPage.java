package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class SignUpPage extends PageBase {

    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By usernameFieldBy = By.id("sign-username");
    By passwordFieldBy = By.id("sign-password");
    By signUpButtonBy = By.xpath("//button[@onclick = 'register()']");


    public void enterUserName(String username){
        WebElement usernameField = driver.findElement(usernameFieldBy);
        fillInElement(usernameField,usernameFieldBy,username);
    }
    public void enterUserPassword(String password){
        WebElement passwordField = driver.findElement(passwordFieldBy);
        fillInElement(passwordField,passwordFieldBy, password);
    }
    public void clickSignUpButton(){
        WebElement signUpButton = driver.findElement(signUpButtonBy);
        clickOnElement(signUpButton,signUpButtonBy);
    }
    public String alertMessage(){
        return driver.switchTo().alert().getText();
    }
    public HomePage acceptAlert(){
        driver.switchTo().alert().accept();
        return new HomePage(driver);
    }
}
