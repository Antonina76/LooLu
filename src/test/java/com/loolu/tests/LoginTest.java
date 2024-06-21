package com.loolu.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void testLogin() {
        clickOnTheGuest();
        click(By.className("User_link__FrsBm"));
        type(By.name("email"), "a.p@ap.com");
        type(By.name("password"), "Qwerty007!");
        click(By.className("User_submit__KttEJ"));
        clickOnTheGuest();
        click(By.cssSelector("p:nth-child(1) "));
        type(By.name("username"), "Toni");
      //  Assert.assertTrue(isElementPresent(By.cssSelector("p:nth-child(4)")));
//enter username
    }

}
