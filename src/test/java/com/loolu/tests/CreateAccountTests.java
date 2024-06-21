package com.loolu.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest(){
//click Guest
        clickOnTheGuest();
//enter firstName
        type(By.name("firstName"), "Antonie");
//enter lastName
        type(By.name("lastName"), "Pavlo");
//enter email
        type(By.name("email"), "a.p5@ap.com");
//enter password
        type(By.name("password"), "Qwerty007!");
//enter username
        type(By.name("username"), "antona");
//enter create an account
        click(By.className("User_submit__KttEJ"));
//assert sign out button is present;
     //   pause(50);
       // clickOnTheGuest();
     //   click(By.cssSelector("p:nth-child(4)"));
      //  Assert.assertTrue(isElementPresent(By.cssSelector("p:nth-child(4)")));
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
