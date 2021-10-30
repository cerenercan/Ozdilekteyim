package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Shop extends StepImplementation {
    @Step("Alışveriş Sayfası Doğrula")
    public void checkShopping(){
        String textCheck = findElement(By.id("com.ozdilek.ozdilekteyim:id/relLayStore")).getAttribute("resource-id");
        Assertions.assertEquals("com.ozdilek.ozdilekteyim:id/relLayStore",textCheck,"Alışveris sayfası açılmıyor");
        logger.info("Alışveriş Sayfası Açıldı");
    }

}
