package com.loolu.tests;

import com.loolu.models.User;
import com.loolu.utils.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTests extends TestBase{
WebDriver driver;
@BeforeMethod
    public void precondition(){
        app.getUser().clickOnTheGuest();
        app.getUser().clickOnTheIAlreadyHaveAnAccount();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLogInButton();
    }

    @Test
    public void addProductToCartFromCategoryGames(){
        app.getHomerPage().click(By.className("Sidebar_link__GW-fE"));
        app.getHomerPage().click(By.className("Products_image__EiUqK"));
        app.getHomerPage().click(By.className("Product_add__e-Wrh"));
        app.getHomerPage().click(By.className("Header_icon-cart__TR11b"));
     //   WebElement element= driver.findElement(By.xpath("//p[contains(text(),'Red Dead Redemption 2')]"));
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Cart_image__eiCxw")));
    }
    @Test
    public void addProductToCartWithoutLogInFromCategoryGames(){
        app.getHomerPage().click(By.className("Sidebar_link__GW-fE"));
        app.getHomerPage().click(By.className("Products_image__EiUqK"));
        app.getHomerPage().click(By.className("Product_add__e-Wrh"));
       // Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Cart_image__eiCxw")));
        Assert.assertTrue(app.getHomerPage().isAlertPresent());
    }


}
