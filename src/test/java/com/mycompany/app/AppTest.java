package com.mycompany.app;
import com.mycompany.app.core.*;

import com.mycompany.app.core.Configuration;

import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
@Listeners({ScreenshotTestListener.class})
public class AppTest
{
    private final String driverPath = "C:/Users/Peres/Desktop/auto_testing/AutomatedTesting/chromedriver.exe";

    @BeforeClass
    public void appSetup() {
        Configuration.init(driverPath);
        System.out.println("The app setup process is completed");
    }

    @DataProvider(name = "minPrice")
    public Object[][] getMinPrice(){ return  new Object[][] {{"10000"}}; }

    @Test(priority = 1)
    public void LogIn_LogOut(){
        LogInOut profile = new LogInOut();
        profile.openAddress();
        profile.clickSignInButton();
        profile.setCredentials();
        profile.submit();
        profile.checkLogin();
        profile.logOut();
    }

    @Test(priority = 2)
    public void searchForm(){
        Search search = new Search();
        search.openAddress();
        search.setSearchText();
        search.findItemInList();
    }

    @Test(priority = 3)
    public void failSearch(){
        Search search = new Search();
        search.openAddress();
        search.setSearchText();
        search.findItemInListFailStep();
    }

    @Test(priority = 4)
    public void cart(){
        Cart cart = new Cart();
        cart.openAddress();
        cart.clickSignInButton();
        cart.setCredentials();
        cart.submit();
        cart.checkLogin();
        cart.findProduct();
        cart.addToCart();
        cart.checkProductInCart();
    }

    @Test(priority = 5, dataProvider = "minPrice")
    public void sortTest(String minPrice){
        Sort sort = new Sort();
        sort.openCatalog();
        sort.setupPrice(minPrice);
        sort.checkPricec(minPrice);
    }



    @AfterClass
    public void closeUp() {
        Configuration.clear();
        System.out.println("The close up process is completed");
    }

    @AfterSuite
    public void cleanUp() {
        System.out.println("All close up activities completed");
    }


}
