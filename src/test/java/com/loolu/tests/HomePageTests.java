package com.loolu.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test

    public void isSignInComponentPresentTest() {
        app.getHomerPage().clickOnTheGuest();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("User_title__gm8FI")));
    }
}
