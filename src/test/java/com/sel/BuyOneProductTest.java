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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author itexps
 */
public class BuyOneProductTest {
    
    public BuyOneProductTest() {
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
    public void testBuyOneProduct() throws InterruptedException{
        driver.get("http://qwqwqwwadvantageonlineshopping.com/");
        driver.findElement(By.id("speakersTxt")).click();
        driver.findElement(By.name("buy_now")).click();
        //driver.findElements(By.id("rabbit")).get(0)
        driver.findElements(By.id("rabbit")).get(1).click();
        driver.findElement(By.className("plus")).click();
        driver.findElement(By.name("save_to_cart")).click();
        driver.findElement(By.id("menuCart")).click();
        driver.findElement(By.id("checkOutButton")).click();
        driver.findElement(By.name("usernameInOrderPayment")).sendKeys("nltest");
        driver.findElement(By.name("passwordInOrderPayment")).sendKeys("Abc@1239");
        driver.findElement(By.id("login_btnundefined")).click();
        driver.findElement(By.id("next_btn")).click();
        driver.findElement(By.name("masterCredit")).click();
        driver.findElement(By.className("edit")).click();
        driver.findElement(By.id("creditCard")).sendKeys("121212121212");
        driver.findElement(By.name("cvv_number")).sendKeys("123");
        driver.findElement(By.name("mmListbox")).sendKeys("11");
        // Optional
        /*WebElement e=driver.findElement(By.name("mmListbox"));
        Select month=new Select(e);
        month.selectByIndex(10);
        month.selectByVisibleText("07");
        month.selectByValue("string:03");*/
        driver.findElement(By.name("yyyyListbox")).sendKeys("2022");
        driver.findElement(By.name("cardholder_name")).sendKeys("test");
        WebElement e=driver.findElement(By.name("save_master_credit"));
        if(e.isSelected()){
            e.click();
        }
        driver.findElement(By.id("pay_now_btn_ManualPayment")).click();
    }
}
