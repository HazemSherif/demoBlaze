package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class LoginPage  extends PageBase {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    WebElement loginUserNameField = driver.findElement(By.id("loginusername"));
    WebElement loginPasswordField = driver.findElement(By.id("loginpassword"));
    WebElement loginButtonConfirm= driver.findElement(By.xpath("//button[@onclick = 'logIn()']"));
    WebElement nameOfUser = driver.findElement(By.id("nameofuser"));



    public void enterName(String name){
        loginUserNameField.sendKeys(name);
    }
    public void enterPassword(String password){
        loginPasswordField.sendKeys(password);
    }
    public HomePage login(){
        loginButtonConfirm.click();
        return new HomePage(driver);
    }
    public String getUserName(){
        return nameOfUser.getText();
    }
}
