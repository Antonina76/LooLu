package com.loolu.tests;

import com.loolu.models.Account;
import com.loolu.utils.AccountData;
import com.loolu.utils.DataProviders;
import com.loolu.utils.UserData;
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
        app.getUser().clickOnTheGuest();
        app.getUser().fillCreateAccountForm(new Account()
                .setFirstname(AccountData.FIRSTNAME)
                .setLastname(AccountData.LASTNAME)
                .setEmail(AccountData.EMAIL)
                .setPassword(AccountData.PASSWORD)
                .setUsername(AccountData.USERNAME));
        app.getUser().clickOnCreateAccountButton();
        //pause(1000);
        app.getUser().click(By.className("Header_avatar__T2JUo"));
      //  app.getUser().click(By.cssSelector("p:nth-child(4) "));
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.xpath("p:nth-child(4)")));

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

    @Test(dataProvider ="createNewAccountFromCSV",dataProviderClass = DataProviders.class)

    public void createNewAccountPositiveTestFromDataProviderWithCSV(Account account) {
        app.getHomerPage().clickOnTheGuest();
        app.getUser().fillCreateAccountForm(account);
        app.getUser().clickOnCreateAccountButton();
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_user__4Ktdg")));

    }
}



