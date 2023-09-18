package pages;

import org.openqa.selenium.*;
import pagehelpers.PageBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends PageBase {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By signUpLinkBy = By.xpath("//li[.//a[@id ='signin2']]");
    By loginButtonBy = By.id("login2");
    By phonesCategoryBy = By.xpath("//a[@onclick = \"byCat('phone')\"]");
    By phoneListsElementsBy = By.xpath("//div[@class = 'card h-100']");
    By laptopsCategoryBy = By.xpath("//a[@onclick = \"byCat('notebook')\"]");
    By productListBy = By.id("tbodyid");
    By monitorCategoryBy = By.xpath("//a[@onclick = \"byCat('monitor')\"]");
    By monitorListsElementsBy = By.xpath("//div[@class = 'card h-100']");
    By categoryListBy = By.className("list-group");
    By listOfCategoriesBy = By.className("list-group-item");
    By listOfProductsBy = By.tagName("img");
    By nameOfUserBy = By.id("nameofuser");


    public SignUpPage clickOnSignUpLink(){
        WebElement signUpLink = driver.findElement(signUpLinkBy);
        clickOnElement(signUpLink,signUpLinkBy);
        return new SignUpPage(driver);
    }
    public LoginPage clickOnLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonBy);
        clickOnElement(loginButton,loginButtonBy);
        return new LoginPage(driver);
    }
    public void clickPhonesCategory(){
        WebElement phonesCategory = driver.findElement(phonesCategoryBy);
        clickOnElement(phonesCategory,phonesCategoryBy);
    }
    public int phoneCategorySize(){

        WebElement phoneList = driver.findElement(productListBy);
        List<WebElement> phoneListsElements = phoneList.findElements(phoneListsElementsBy);
        return phoneListsElements.size();
    }
    public void clickLaptopCategory(){
        WebElement laptopsCategory = driver.findElement(laptopsCategoryBy);
        clickOnElement(laptopsCategory,laptopsCategoryBy);
    }
    public int laptopCategorySize(){
        WebElement laptopList = driver.findElement(productListBy);
        List<WebElement> laptopListsElements = laptopList.findElements(By.xpath("//div[@class = 'card h-100']"));
        return laptopListsElements.size();
    }
    public void clickMonitorCategory(){
        WebElement monitorCategory = driver.findElement(monitorCategoryBy);
        clickOnElement(monitorCategory,monitorCategoryBy);
    }
    public int monitorCategorySize(){
        WebElement monitorLists = driver.findElement(productListBy);
        List<WebElement> monitorListsElements = monitorLists.findElements(monitorListsElementsBy);
        return monitorListsElements.size();
    }
    public void randomCategorySelector(){

        WebElement categoryList = driver.findElement(categoryListBy);
        List<WebElement> listOfCategories = categoryList.findElements(listOfCategoriesBy);

        List<WebElement> filteredElements = new ArrayList<>();
        for (WebElement element : listOfCategories) {
            if (!element.getText().equals("CATEGORIES")) {
                filteredElements.add(element);
            }
        }
        //Select random category
        Random random = new Random();
        int randomCategory = random.nextInt(filteredElements.size());
        clickOnElement(filteredElements.get(randomCategory),listOfCategoriesBy);

    }
    public ProductPage randomProductSelector(){
        WebElement productList = driver.findElement(productListBy);
        List<WebElement> listOfProducts = productList.findElements(listOfProductsBy);
        Random randomNumber = new Random();
        int randomProduct;
        try{
            randomProduct= randomNumber.nextInt(listOfProducts.size());
            scrollToScreenCenter();
            clickOnElement(listOfProducts.get(randomProduct),listOfProductsBy);
        } catch (StaleElementReferenceException e){
             productList = driver.findElement(productListBy);
             listOfProducts = productList.findElements(listOfProductsBy);
             randomProduct = randomNumber.nextInt(listOfProducts.size());
             scrollToScreenCenter();
             clickOnElement(listOfProducts.get(randomProduct),listOfProductsBy);
        }

        return new ProductPage(driver);
    }
    public String getUserName() {
        WebElement nameOfUser = driver.findElement(nameOfUserBy);
        try{
            return getElementText(nameOfUser,nameOfUserBy);
        } catch(StaleElementReferenceException e){
            nameOfUser = driver.findElement(nameOfUserBy);
        }
        return getElementText(nameOfUser,nameOfUserBy);
    }
}
