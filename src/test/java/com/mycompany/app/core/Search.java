package com.mycompany.app.core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.mycompany.app.core.Helpers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Search {

    @Step("Open first page")
    public void openAddress() {
        navigate("https://www.chipdip.ru/");
    }

    @Step("Entering search text")
    public void setSearchText() {
        waitUntilElementAppears(By.name("searchtext"));
        sendText("UC2846N", By.name("searchtext"));
        presEnter(By.name("searchtext"));
    }

    @Step("Finding items from list")
    public void findItemInList() {
        waitUntilElementAppears(By.linkText("Каталог"));
        assertTrue(elementExists(By.xpath("//b[contains(.,\'UC2846N\')]")), "UC2846N");
    }
    @Step("Fail step")
    public void findItemInListFailStep(){
        waitUntilElementAppears(By.linkText("Catalogue"));
        assertTrue(elementExists(By.xpath("//b[contains(.,\'UC2846N\')]")), "UC2846N");
    }
}
