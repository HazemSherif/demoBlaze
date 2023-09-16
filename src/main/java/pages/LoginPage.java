package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class LoginPage  extends PageBase {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By loginUserNameFieldBy = By.id("loginusername");
    By loginPasswordFieldBy = By.id("loginpassword");
    By loginButtonConfirmBy = By.xpath("//button[@onclick = 'logIn()']");

    public void enterName(String name){
        WebElement loginUserNameField = driver.findElement(loginUserNameFieldBy);
        fillInElement(loginUserNameField,loginUserNameFieldBy, name);
    }
    public void enterPassword(String password){
        WebElement loginPasswordField = driver.findElement(loginPasswordFieldBy);
        fillInElement(loginPasswordField,loginPasswordFieldBy, password);
    }
    public HomePage login(){
        WebElement loginButtonConfirm= driver.findElement(loginButtonConfirmBy);
        clickOnElement(loginButtonConfirm,loginButtonConfirmBy);
        return new HomePage(driver);
    }

}
