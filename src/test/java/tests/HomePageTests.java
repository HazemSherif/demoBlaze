package tests;

import helpers.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void checkCategoriesContainsProducts(){
        homePage.clickPhonesCategory();
        Assert.assertNotEquals(0,homePage.phoneCategorySize());
        homePage.clickLaptopCategory();
        Assert.assertNotEquals(0,homePage.laptopCategorySize());
        homePage.clickMonitorCategory();
        Assert.assertNotEquals(0,homePage.monitorCategorySize());
    }
}
