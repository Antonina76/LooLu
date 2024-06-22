package com.loolu.tests;

import com.loolu.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",Browser.CHROME.browserName()));

    @BeforeSuite
  //  @BeforeMethod
    public void setUp() {
    app.init();
}

    @AfterSuite(enabled = false)
  //  @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }


    public boolean isSignInComponentPresent() {
        return app.getHomerPage().isElementPresent(By.className("User_title__gm8FI"));
    }
}
