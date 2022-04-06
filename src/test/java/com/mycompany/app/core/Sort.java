package com.mycompany.app.core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mycompany.app.core.Helpers.*;
import static org.testng.Assert.*;

public class Sort {

    @Step("Opening catalog")
    public void openCatalog(){
        navigate("https://www.chipdip.ru/catalog-show/scopemeters");
    }

    @Step("Set up price")
    public void setupPrice(String minPrice){
        sendText(minPrice, By.xpath("//input[@id='input_prices_min']"));
        click(By.id("btn_prices"));
    }

    @Step("Check prices")
    public void checkPricec(String minPrice){
        sleep(5);
        for (WebElement element : getElements(By.className("item__price"))){
            String Snum = element.getText().replaceAll("руб.", "");
            Snum = Snum.replaceAll(" ", "");
            Integer num = Integer.parseInt(Snum);
            assertTrue(num >= Integer.parseInt(minPrice), "Filter error");
        }
    }
}
