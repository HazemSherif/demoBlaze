package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartPageTests extends BaseTest {
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
