package com.loolu.tests;

import com.loolu.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setEmail("a.pap.com").setPassword("Qwerty007!"));
        app.getUser().clickOnLogInButton();
        // click(By.className("User_close__cXNYs"));
        //  click(By.className("Header_username__S3AFn"));
        //click(By.cssSelector("p:nth-child(4) "));
        // Assert.assertTrue(isAssertPresent());
        //   type(By.name("username"), "Toni");
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));
//enter username
    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setPassword("Qwerty007!"));
        app.getUser().clickOnLogInButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));
    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutPassword() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setEmail("a.p@ap.com"));
        app.getUser().clickOnLogInButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));
    }
}