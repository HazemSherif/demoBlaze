package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class SignUpPage extends PageBase {

    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement usernameField = driver.findElement(By.id("sign-username"));
    WebElement passwordField = driver.findElement(By.id("sign-password"));
    WebElement signUpButton = driver.findElement(By.xpath("//button[@onclick = 'register()']"));


    public void enterUserName(String username){
        usernameField.sendKeys(username);
    }
    public void enterUserPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSignUpButton(){
        signUpButton.click();

    }
    public String alertMessage(){
        return driver.switchTo().alert().getText();
    }
    public HomePage acceptAlert(){
        driver.switchTo().alert().accept();
        return new HomePage(driver);
    }
}
