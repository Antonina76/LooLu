package com.loolu.tests;

import com.loolu.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",Browser.CHROME.browserName()));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeMethod
  public void startTest(Method method,Object[] p){
      logger.info("Start test"+method.getName()+ " with data: "+ Arrays.asList(p));

  }

    @AfterMethod(enabled = true)
    public void stopTest(ITestResult result){
       if(result.isSuccess()) {
           logger.info("PASSED: " + result.getMethod().getMethodName());
       }else{
           logger.error("FAILED: " + result.getMethod().getMethodName() + "Screenshot: " + app.getUser().takeScreenShot());
       }
        logger.info("**************************");
    }

    @BeforeSuite
    public void setUp() {
    app.init();
}

     @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }


    public boolean isSignInComponentPresent() {
        return app.getHomerPage().isElementPresent(By.className("User_title__gm8FI"));
    }


}




