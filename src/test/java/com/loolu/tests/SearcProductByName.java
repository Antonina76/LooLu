package com.loolu.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearcProductByName extends TestBase{
    @Test
    public void searcProductByName(){
      //  click(By.name("search"));
        app.getUser().type(By.name("search"),"Wireless Mouse");
        Assert.assertTrue(app.getHomerPage().isElementPresent(By.className("Header_item__VxePD")));
    }

    }

