package org.example;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StepImplementation extends BaseTest{

    @Step("<time> saniye bekle")
    public void waitSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("<Key> İd'li elemente tıkla")
    public void clickElementByid(String Key) {
        clickElement(By.id(Key));
        System.out.println(Key + "Elementine tiklandi");
    }

    @Step("<Key> İd'li elemente <keywordc> değerini yaz")
    public void SendkeyElementByid(String Key, String keyword) {
        appiumDriver.findElement(By.id(Key)).sendKeys(keyword);
        System.out.println(Key + "Elementine tiklandi");
    }

    @Step("<Key> xpath'li elemente tıkla")
    public void clickElementByXpath(String Key) {
        clickElement(By.xpath(Key));
        //appiumDriver.findElement(By.xpath(Key)).click();
        System.out.println(Key + "Elementine tiklandi");
    }

    @Step("sayfa boyunca scroll et")
    public void scrollToRandom() {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction(appiumDriver);
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();
    }

    @Step("<Key> xpath'te bulunan sayfada görünen tüm ürünleri bul ve rastgele bir ürüne tıkla")
    public void findAllProducts(String Key){
        List<MobileElement> productList = appiumDriver.findElementsByXPath(Key);
        int size = productList.size();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(size);
        productList.get(randomInt).click();

    }
    @Step("Sepete ekle")
    public void addToBasket(){

        clickElementByXpath("//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout[@index=0]");
        clickElementByid("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn");

    }

    //-----------------------------------------------------------------------------

    protected JavascriptExecutor getJSExecutor() {
        return appiumDriver;
    }

    protected void scrollTo(int x, int y) {
        String jsStmt = String.format("window.scrollTo(%d, %d);", x, y);
        getJSExecutor().executeScript(jsStmt, true);
    }
    public void waitUntilPresence(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public void waitUntilElementClickable(By by) {
        System.out.println(by.toString()+" -> elementinin tiklanabilir olmasi bekleniyor");
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement findElement(By locator) {
        return appiumDriver.findElement(locator);
    }

    public void clickElement(By by) {
        waitUntilPresence(by);
        WebElement element;
        element = findElement(by);
        if (!element.isDisplayed()) {
            scrollTo(element.getLocation().getX(), element.getLocation().getY());
        }
        try {
            waitUntilElementClickable(by);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        element.click();
    }
}
