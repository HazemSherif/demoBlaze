package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class CartPage extends PageBase {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By purchaseButtonBy = By.className("btn-success");
    By nameFieldBy =  By.id("name");
    By creditCardFieldBy = By.id("card");
    By confirmPurchaseButtonBy = By.xpath("//button[@onclick = \"purchaseOrder()\"]");
    By deleteProductBy = By.xpath("(//a[normalize-space()='Delete'])[1]");
    By confirmationPopUpBy = By.className("sweet-alert");
    By okButtonBy = By.className("confirm");

    public void clickOnPurchaseButton(){
        WebElement purchaseButton = driver.findElement(purchaseButtonBy);
        clickOnElement(purchaseButton,purchaseButtonBy);
    }
    public void enterName(){
        WebElement nameField = driver.findElement(nameFieldBy);
        fillInElement(nameField,nameFieldBy,"user name");
    }
    public void enterCardNumber(){
        WebElement creditCardField = driver.findElement(creditCardFieldBy);
        fillInElement(creditCardField,creditCardFieldBy,"4242424242424242");
    }
    public void pressThePurchaseButton(){
        WebElement confirmPurchaseButton = driver.findElement(confirmPurchaseButtonBy);
        clickOnElement(confirmPurchaseButton,confirmPurchaseButtonBy);
    }
    public void clickOnDeleteButton(){
        WebElement deleteProduct = driver.findElement(deleteProductBy);
        clickOnElement(deleteProduct,deleteProductBy);
    }
    public String successMessageText(){
        WebElement confirmationPopUp = driver.findElement(confirmationPopUpBy);
        return getElementText(confirmationPopUp,confirmationPopUpBy);
    }
    public void clickOnOkButton(){
        WebElement okButton = driver.findElement(okButtonBy);
        clickOnElement(okButton,okButtonBy);
    }


}
