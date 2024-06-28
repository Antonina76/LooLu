package com.loolu.tests;

import com.loolu.models.User;
import com.loolu.utils.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {
WebDriver driver;
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
        app.pause(2000);
        WebElement element= driver.findElement(By.xpath("//p[contains(text(),'Sign Out')][3]"));
        assertTrue(element.getText().contains("Sign Out"));

        //  app.getUser().click(By.cssSelector("Header_avatar__T2JUo"));
        // Assert.assertTrue(isAssertPresent());
        //   type(By.name("username"), "Toni");
        // pause(2000);
        //app.getUser().click(By.xpath("p:nth-child(1)"));
       // Assert.assertTrue(app.getHomerPage().isElementPresent(By.xpath("p:nth-child(1)")));

    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setEmail(UserData.WRONGEMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLogInButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.className("CustomAlert_btn__ADxic")));
    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutPassword() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setEmail(UserData.WRONGPASSWORD));
        app.getUser().clickOnLogInButton();
        assertTrue(app.getHomerPage().isElementPresent(By.className("User_submit__KttEJ")));
    }
}