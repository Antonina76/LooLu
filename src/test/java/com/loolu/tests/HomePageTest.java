package com.loolu.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class HomePageTest {
    @BeforeMethod


    }

    @Test
    public void isHomeComponentPresentTest() {
        // System.out.println("Home component is " + isHomeComponentPresent());
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
}
