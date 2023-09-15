package pagehelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;}
    public void waitForElementToBeDisplayed(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    public void waitForAlertToBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until((ExpectedConditions.alertIsPresent()));
    }
    public void clickOnElement(WebElement element, By elementBy){
        waitForElementToBeDisplayed(elementBy);
        element.click();
    }
    public void fillInElement(WebElement element, By elementBy, String value){
        waitForElementToBeDisplayed(elementBy);
        element.sendKeys(value);
    }
    public String getElementText(WebElement element,By elementBy){
        waitForElementToBeDisplayed(elementBy);
        return element.getText();
    }
    public void acceptAlertBase(){
        waitForAlertToBeDisplayed();
        driver.switchTo().alert().accept();
    }
    public String getAlertMessageBase(){
        waitForAlertToBeDisplayed();
        return driver.switchTo().alert().getText();
    }

}
