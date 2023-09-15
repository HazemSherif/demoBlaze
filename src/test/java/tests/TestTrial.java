package tests;

import helpers.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestTrial extends TestBase {
    String randomString = generateRandomString();
    @Test
    public void SignUp(){
        SignUpPage signUpPage = homePage.clickOnSignUpLink();
        signUpPage.enterUserName(randomString);
        signUpPage.enterUserPassword("12345");
        signUpPage.clickSignUpButton();
        Assert.assertEquals(signUpPage.alertMessage(),"Sign up successful.");
        homePage = signUpPage.acceptAlert();
    }
    @Test(dependsOnMethods = {"SignUp"})
    public void Login(){
        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.enterName(randomString);
        loginPage.enterPassword("12345");
        homePage = loginPage.login();
        Assert.assertEquals(loginPage.getUserName(), "Welcome"+ randomString);
    }
    @Test
    public void checkCategoriesContainsProducts(){
        homePage.clickPhonesCategory();
        Assert.assertNotEquals(0,homePage.phoneCategorySize());
        homePage.clickLaptopCategory();
        Assert.assertNotEquals(0,homePage.laptopCategorySize());
        homePage.clickMonitorCategory();
        Assert.assertNotEquals(0,homePage.monitorCategorySize());
    }
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
        Assert.assertEquals("Thank you for your purchase!", cartPage.successMessageText());
        cartPage.clickOnOkButton();
    }

}
