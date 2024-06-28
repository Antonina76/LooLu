package com.loolu.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class ApplicationManager  {

    static WebDriver driver;

    String browser;
    UserHelper user;
    HomePageHelper homerPage;
    CartHelper cartHelper;

    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public  void init() {
        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver= new EdgeDriver();
        }
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        homerPage = new HomePageHelper(driver);

    }

    public UserHelper getUser() {
        return user;
    }

    public HomePageHelper getHomerPage() {
        return homerPage;
    }

    public static void stop() {
        driver.quit();
    }

    public void pause (int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
