/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sel;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class HotmailTest {
    
    public HotmailTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    WebDriver driver;
    @Before
    public void setUp() {
       System.setProperty("webdriver.chrome.driver", "c:\\qa\\drivers\\chromedriver.exe");
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testLogin() throws InterruptedException{
        driver.get("http://www.hotmail.com"); //Got to hotmail home page
        driver.findElement(By.partialLinkText("Sign in")).click(); // click on signin link
        driver.findElement(By.id("i0116")).sendKeys("SelSample@hotmail.com");
        driver.findElement(By.id("idSIButton9")).click();
        //Thread.currentThread().sleep(5000);
        //Thread.sleep(0);
        WebElement e=driver.findElement(By.name("passwd"));
        e.clear();
        e.sendKeys("Sel@123!");
        e.submit();
    }
}
