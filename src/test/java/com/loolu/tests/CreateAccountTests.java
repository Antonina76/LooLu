package com.loolu.tests;

import com.loolu.models.Account;
import com.loolu.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().fillCreateAccountForm(new Account()
                .setFirstname("Anto")
                .setLastname("Pavlo")
                .setEmail("an.doki9@gmail.com")
                .setPassword("Qwerty007!")
                .setUsername("doantoni"));
        app.getUser().clickOnCreateAccountButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));

    }

    @Test(dataProvider ="createNewAccount",dataProviderClass = DataProviders.class)
    public void createNewAccountPositiveTestFromDataProvider(String firstname, String lastname,  String email, String password,String username) {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().fillCreateAccountForm(new Account()
                .setFirstname(firstname)
                .setLastname(lastname)
                .setEmail(email)
                .setPassword(password)
                .setUsername(username));
        app.getUser().clickOnCreateAccountButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));

    }

    @Test(dataProvider ="createNewAccountFromCSV",dataProviderClass = DataProviders.class )
    public void createNewAccountPositiveTestFromDataProviderWithCSV(Account account) {

        app.getHomerPage().clickOnTheGuest();
        app.getUser().fillCreateAccountForm(account);
        app.getUser().clickOnCreateAccountButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));

    }
}



