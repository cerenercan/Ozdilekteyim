package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Home extends StepImplementation {

    @Step("Açılış Sayfası Kontrol")
    public void open() {
        String alisveriseBaslaButton = findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA",alisveriseBaslaButton,"Hatalı/Yanlış Buton");
        logger.info("Uygulama ayağa kalktı");
    }
}
