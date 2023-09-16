package pagehelpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;}

    // Handles clicking on stale elements
     /*  public void waitForStaleElement(WebElement el, By by){
        new WebDriverWait(driver,Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class).until((driver) ->{
            clickOnElement(el, by);
            return true;
        });
    }*/

    public void waitForElementToBeDisplayed(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public void scrollToScreenCenter(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
    }
}
