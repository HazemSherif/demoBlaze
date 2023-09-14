package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

public class ProductPage extends PageBase {

    WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement addToCart = driver.findElement(By.className("btn-success"));
    WebElement cartPage = driver.findElement(By.id("cartur"));

    public void addProductToCart(){
        clickOnElement(addToCart);
        driver.switchTo().alert().accept();
    }
    public CartPage goToCart(){
        clickOnElement(cartPage);
        return new CartPage(driver);
    }


}
