package com.loolu.tests;

import com.loolu.models.Account;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().fillCreateAccountForm(new Account()
                .setEmail("an.doki8@gmail.com")
                .setPassword("Qwerty007!")
                .setFirstname("Antonina")
                .setLastname("Pavlov")
                .setUsername("doantoni"));
        app.getUser().clickOnCreateAccountButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));

    }

}


