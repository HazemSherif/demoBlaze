package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class ProductPage extends PageBase {

    WebDriver driver;
    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By addToCartBy = By.className("btn-success");
    By cartPageBy = By.id("cartur");

    public void addProductToCart(){
        WebElement addToCart = driver.findElement(addToCartBy);
        clickOnElement(addToCart,addToCartBy);
        driver.switchTo().alert().accept();
    }
    public CartPage goToCart(){
        WebElement cartPage = driver.findElement(cartPageBy);
        clickOnElement(cartPage,cartPageBy);
        return new CartPage(driver);
    }


}
