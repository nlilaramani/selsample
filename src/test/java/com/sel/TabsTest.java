/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class TabsTest {
    
    public TabsTest() {
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
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
    public void testNewTabs(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.switchTo().frame("iframe_1");
        driver.get("http://www.ibm.com");
    }
    
    @Test
    public void testPopups() throws InterruptedException{
        driver.get("https://nlilaramani.github.io/frame.html");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    
}
