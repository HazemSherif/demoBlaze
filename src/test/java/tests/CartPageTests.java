package tests;

import helpers.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartPageTests extends TestBase {
    @Test
    public void removeRandomProductFromCart(){
        homePage.randomCategorySelector();
        ProductPage productPage = homePage.randomProductSelector();
        productPage.addProductToCart();
        CartPage cartPage = productPage.goToCart();
        cartPage.clickOnDeleteButton();
    }
    @Test
    public void checkOutWithRandomProduct(){

        homePage.randomCategorySelector();
        ProductPage productPage = homePage.randomProductSelector();
        productPage.addProductToCart();
        CartPage cartPage = productPage.goToCart();
        cartPage.clickOnPurchaseButton();
        cartPage.enterName();
        cartPage.enterCardNumber();
        cartPage.pressThePurchaseButton();
        Assert.assertTrue(cartPage.successMessageText().contains("Thank you for your purchase!"));
        cartPage.clickOnOkButton();
    }


}
