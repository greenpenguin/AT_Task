package com.mycompany.app.core;


import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.mycompany.app.core.Helpers.*;
import static org.testng.Assert.*;

public class Cart {
    @Step("Opening main page")
    public void openAddress() {
        navigate("https://www.chipdip.ru/");
    }

    @Step("Click on sign in button")
    public void clickSignInButton(){
        waitUntilElementAppears(By.xpath("//a[@id=\'logonlink\']/span/span"));
        click(By.xpath("//a[@id=\'logonlink\']/span/span"));
    }

    @Step("Entering credentials")
    public void setCredentials(){
        sendText("testing2", By.name("login"));
        sendText("123qwe", By.name("pwd"));
    }

    @Step("Submit login")
    public void submit(){
        waitUntilElementAppears(By.xpath("(//button[@type=\'submit\'])[2]"));
        click(By.xpath("(//button[@type=\'submit\'])[2]"));
    }

    @Step("Checking if is signed in")
    public void checkLogin(){
        waitUntilElementAppears(By.xpath("//div[@id=\'content_main\']/div/h1"));
        assertTrue(elementExists(By.cssSelector("h1")), "Личный кабинет");
        System.out.println("The login process completed");
    }

    @Step("Find page")
    public void findProduct() {
        navigate("https://www.chipdip.ru/");
        waitUntilElementAppears(By.name("searchtext"));
        sendText("UC2846N", By.name("searchtext"));
        presEnter(By.name("searchtext"));
    }

    @Step("Add to cart")
    public void addToCart(){
        waitUntilElementAppears(By.xpath("//span[contains(.,'В корзину')]"));
        click(By.xpath("//span[contains(.,'В корзину')]"));
    }

    @Step("Check if product on favorites")
    public void checkProductInCart(){
        waitUntilElementAppears(By.xpath("//span[contains(.,'В корзине')]"));
        click(By.xpath("//span[contains(.,'В корзине')]"));
        assertTrue(elementExists(By.xpath("//*[@id=\"cart\"]/tbody/tr[1]/td[1]/a")), "UC2846N, ШИМ-контроллер, Current Mode [DIP-16]");
    }
}
