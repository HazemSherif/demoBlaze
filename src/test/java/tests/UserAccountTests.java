package tests;

import helpers.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class UserAccountTests extends TestBase {
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
    public void Login() {
        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.enterName(randomString);
        loginPage.enterPassword("12345");
        homePage = loginPage.login();
        Assert.assertEquals(homePage.getUserName(), "Welcome "+ randomString);
    }



}