package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Login extends StepImplementation {
    @Step("Login page doğrulama")
    public void checkLogin(){
        boolean isLoginButtonVisible = findElement(By.id("com.ozdilek.ozdilekteyim:id/btnLogin")).isDisplayed();
        Assertions.assertTrue(isLoginButtonVisible,"login sayfası dogrulanmadı");
        logger.info("login sayfası doğrulandı");
    }
}
