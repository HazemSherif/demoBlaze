package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class CartPage extends PageBase {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement purchaseButton = driver.findElement(By.className("btn-success"));
    WebElement nameField = driver.findElement(By.id("name"));
    WebElement creditCardField = driver.findElement(By.id("card"));
    WebElement confirmPurchaseButton = driver.findElement(By.xpath("//button[@onclick = \"purchaseOrder()\"]"));
    WebElement deleteProduct = driver.findElement(By.xpath("(//a[normalize-space()='Delete'])[1]"));
    WebElement confirmationPopUp = driver.findElement(By.className("sweet-alert"));
    WebElement okButton = driver.findElement(By.className("confirm"));

    public void clickOnPurchaseButton(){
        clickOnElement(purchaseButton);
    }
    public void enterName(){
        fillInElement(nameField,"user name");
    }
    public void enterCardNumber(){
        fillInElement(creditCardField,"4242424242424242");
    }
    public void pressThePurchaseButton(){
        clickOnElement(confirmPurchaseButton);
    }
    public void clickOnDeleteButton(){
        clickOnElement(deleteProduct);
    }
    public String successMessageText(){
        return getElementText(confirmationPopUp);
    }
    public void clickOnOkButton(){
        clickOnElement(okButton);
    }



}
