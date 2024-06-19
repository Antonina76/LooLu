package com.loolu.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void isGuestComponentPresentTest() {
        Assert.assertTrue(isGuestComponentPresent());
    }
    public boolean isGuestComponentPresent() {
        return driver.findElements(By.className("Header_avatar__T2JUo")).size()>0;
    }
}
