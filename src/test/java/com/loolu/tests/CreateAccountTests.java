package com.loolu.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest(){
//click Guest
        driver.findElement(By.className("Header_avatar__T2JUo")).click();
//enter firstName
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys("Antonq");
//enter lastName
        driver.findElement(By.name("lastName")).click();
        driver.findElement(By.name("lastName")).clear();
        driver.findElement(By.name("lastName")).sendKeys("Pavlovlo");
//enter email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("a.p8@ap.com");
//enter password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Qwerty007!");
//enter username
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("antPavÜ");
//enter create an account
       driver.findElement(By.className("User_submit__KttEJ")).click();
//assert sign out button is present
        driver.findElement(By.className("Header_username__S3AFn")).click();
       Assert.assertTrue(isElementPresent(By.xpath("//p[contains(text(),'Sign Out')]")));
    }
}
