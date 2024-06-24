package com.loolu.tests;

import com.loolu.models.User;
import com.loolu.utils.UserData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLogInButton();
        app.pause(2000);
      //app.getUser().click(By.className("User_close__cXNYs"));
       // app.getUser().click(By.className("Header_username__S3AFn"));
        app.getUser().clickOnTheGuest();
      //  app.getUser().click(By.cssSelector("Header_avatar__T2JUo"));
        // Assert.assertTrue(isAssertPresent());
        //   type(By.name("username"), "Toni");
       // pause(2000);
        //app.getUser().click(By.xpath("p:nth-child(1)"));
       Assert.assertTrue(app.getHomerPage().isElementPresent(By.xpath("p:nth-child(1)")));

    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setPassword(UserData.WRONGEMAIL));
        app.getUser().clickOnLogInButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("User_submit__KttEJ")));
    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutPassword() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setEmail(UserData.WRONGPASSWORD));
        app.getUser().clickOnLogInButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("User_submit__KttEJ")));
    }
}
