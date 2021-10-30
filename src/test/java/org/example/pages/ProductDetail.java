package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductDetail extends StepImplementation {
    @Step("Product detail sayfası doğrulama")
    public void checkProductDetail(){
        boolean checkProductDetail = findElement(By.id("com.ozdilek.ozdilekteyim:id/imgCart")).isDisplayed();
        Assertions.assertTrue(checkProductDetail,"Product detay sayfası hatalı");
        logger.info("Product detail sayfasında olduğu doğrulandı");
    }
}
