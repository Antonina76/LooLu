package com.loolu.fw;

import com.loolu.models.Account;
import com.loolu.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class UserHelper extends BaseHelper {


    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void fillCreateAccountForm(Account account) {
        type(By.name("firstName"), account.getFirstname());
        type(By.name("lastName"), account.getLastname());
        type(By.name("email"), account.getEmail());
        type(By.name("password"), account.getPassword());
        type(By.name("username"), account.getUsername());
    }

    public void clickOnCreateAccountButton() {
        click(By.className("User_submit__KttEJ"));
    }

    public void clickOnLogInButton() {
        click(By.className("User_submit__KttEJ"));
    }

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnTheIAlreadyHaveAnAccount() {
        click(By.className("User_link__FrsBm"));
    }

}