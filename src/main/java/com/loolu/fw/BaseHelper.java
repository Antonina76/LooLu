package com.loolu.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return ApplicationManager.driver.findElements(locator).size() > 0;
    }


    public void type(By locator, String text) {
       if(text != null) {
           click(locator);
           ApplicationManager.driver.findElement(locator).clear();
           ApplicationManager.driver.findElement(locator).sendKeys(text);
       }
    }

    public void clickOnTheGuest() {
        click(By.className("Header_avatar__T2JUo"));
    }

    public void click(By locator) {
        ApplicationManager.driver.findElement(locator).click();
    }

    public boolean isAlertPresent(){
            Alert alert = new WebDriverWait(ApplicationManager.driver, Duration.ofSeconds(50))
                    .until(ExpectedConditions.alertIsPresent());
            if (alert == null) {
                return false;
            }else {
                alert.accept();
                return true;
            }
    }

    public String  takeScreenShot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();

    }

}
