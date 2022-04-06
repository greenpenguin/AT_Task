package com.mycompany.app.core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.mycompany.app.core.Helpers.*;
import static com.mycompany.app.core.Helpers.waitUntilElementAppears;
import static org.testng.Assert.assertTrue;

public class LogInOut {

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
        System.out.println("Waiting for login");

        assertTrue(elementExists(By.cssSelector("h1")), "Личный кабинет");
        System.out.println("The login process completed");
    }

    @Step("Log out")
    public void logOut(){
        waitUntilElementAppears(By.linkText("Выход"));
        click(By.linkText("Выход"));
    }
}
