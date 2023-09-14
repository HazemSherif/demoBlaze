package pagehelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;


public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;}

    public PageBase() {

    }


    public void clickOnElement(WebElement element){
        element.click();
    }
    public void fillInElement(WebElement element, String value){
        element.sendKeys(value);
    }
    public String getElementText(WebElement element){
        return element.getText();
    }


}
