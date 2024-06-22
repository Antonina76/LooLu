package com.loolu.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase {
    @Test
    public void testLogin() {
        clickOnTheGuest();
        click(By.className("User_link__FrsBm"));
        type(By.name("email"), "a.p@ap.com");
        type(By.name("password"), "Qwerty007!");
        click(By.className("User_submit__KttEJ"));
    // click(By.className("User_close__cXNYs"));
      //  click(By.className("Header_username__S3AFn"));
        //click(By.cssSelector("p:nth-child(4) "));
        Assert.assertTrue(isAssertPresent());
     //   type(By.name("username"), "Toni");
    //  Assert.assertTrue(isElementPresent(By.cssSelector("p:nth-child(4)")));
//enter username
    }
public boolean isAssertPresent(){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;

        }else {
            return true;
        }
}
    }


