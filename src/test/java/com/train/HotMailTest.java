/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.train;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author itexps
 */
public class HotMailTest {
    
    public HotMailTest() {
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
       WebDriver.Timeouts t=driver.manage().timeouts();
       t.implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testLogin() throws InterruptedException {
       driver.get("http://www.hotmail.com");
        WebElement e=driver.findElement(By.partialLinkText("Sign"));
        e.click();
        e=driver.findElement(By.id("i0116"));
        //e=driver.findElement(By.id("i0116"));
        //e=driver.findElement(By.id("i0116"));
        e.sendKeys("SelSample@hotmail.com");
        driver.findElement(By.id("idSIButton9")).click();
        Thread.currentThread().sleep(1000);
        e=driver.findElement(By.name("passwd"));
        e.clear();
        e.sendKeys("Sel@123!");
        e.submit();
     }
     
     @Test
     public void testLoginFile() throws InterruptedException, FileNotFoundException {
       driver.get("http://www.hotmail.com");
        WebElement e=driver.findElement(By.partialLinkText("Sign"));
        e.click();
        
         FileInputStream fs=new FileInputStream(new File("c:\\qa\\hm.xslx"));
         Workbook wb=new XSSFWorkbook(fs);

        
        e=driver.findElement(By.id("i0116"));
        //e=driver.findElement(By.id("i0116"));
        //e=driver.findElement(By.id("i0116"));
        e.sendKeys("SelSample@hotmail.com");
        driver.findElement(By.id("idSIButton9")).click();
        Thread.currentThread().sleep(1000);
        e=driver.findElement(By.name("passwd"));
        e.clear();
        e.sendKeys("Sel@123!");
        e.submit();
     }
     
     
     @Test
     public void testCss(){
         driver.get("http://www.facebook.com");
         driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("dksdjjk");
       //  driver.findElement(By.cssSelector("input.inputtext")).sendKeys("Software testing");
     }
     
     @Test
     public void dropdownTest(){
         driver.get("http://softwaretestingmaterial.com/sample-webpage-to-automate");
         WebElement e=driver.findElement(By.name("dropdown"));
         Select s=new Select(e);
         s.selectByVisibleText("Automation Testing");
         e=driver.findElement(By.name("multipleselect[]"));
         s=new Select(e);
         s.selectByIndex(0);
         s.selectByIndex(1);
     }
     
     @Test
     public void someTest() throws InterruptedException{
         driver.get("http://advantageonlineshopping.com/#/");
         Thread.currentThread().sleep(5000);
         WebElement e=driver.findElement(By.id("menuUserLink"));
         e.click();
         
         Thread.currentThread().sleep(2000);
         new WebDriverWait(driver,10000)
                 .until(ExpectedConditions
                 .presenceOfElementLocated(By.partialLinkText("CREATE NEW ACCOUNT")));
       
         WebElement e1=driver.findElement(By.partialLinkText("CREATE NEW ACCOUNT"));
         e1.click();
         Thread.currentThread().sleep(20000);
         new WebDriverWait(driver,10000)
                 .until(ExpectedConditions
                 .presenceOfElementLocated(By.name("usernameRegisterPage")));
         driver.findElement(By.name("usernameRegisterPage")).sendKeys("nltest");
         driver.findElement(By.xpath("//input[@name='emailRegisterPage']")).sendKeys("nl@test.com");
         driver.findElement(By.name("passwordRegisterPage")).sendKeys("Abc@1239");
         driver.findElements(By.xpath("//input[@type='password']")).get(2).sendKeys("Abc@1239");
         WebElement s=driver.findElement(By.name("countryListboxRegisterPage")); 
         new Select(s).selectByVisibleText("United States");
         WebElement promo=driver.findElement(By.name("allowOffersPromotion"));
         if(promo.isSelected()){
             System.out.println("Promo is selected");
         }
         promo.click();
         driver.findElement(By.name("i_agree")).click();
         driver.findElement(By.id("register_btnundefined")).click();
     }
     @Test
     public void testShopping(){
         driver.get("http://advantageonlineshopping.com/#/");
         driver.findElement(By.id("speakersTxt")).click();
         driver.findElement(By.id("accordionPrice")).click();
         WebElement e2=driver.findElement(By.className("noUi-handle-upper"));
         e2.click();
         Actions a=new Actions(driver).moveToElement(e2).moveByOffset(-20, 0).click();
         a.build().perform();
         WebElement e3=driver.findElement(By.id("20"));
         driver.findElement(By.id("accordionColor")).click();
     }
     @Test
     public void testBuyOneProduct(){
         driver.get("http://advantageonlineshopping.com/#/");
         driver.findElement(By.id("speakersTxt")).click();
         driver.findElement(By.name("buy_now")).click();
         driver.findElements(By.id("rabbit")).get(0).click();
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
         driver.findElement(By.id("creditCard")).clear();
         driver.findElement(By.id("creditCard")).sendKeys("123456789012");
         driver.findElement(By.name("cvv_number")).clear();
         driver.findElement(By.name("cvv_number")).sendKeys("1123");
         driver.findElement(By.name("mmListbox")).sendKeys("11");
         driver.findElement(By.name("yyyyListbox")).sendKeys("2027");
         driver.findElement(By.name("cardholder_name")).sendKeys("NL");
         driver.findElement(By.id("pay_now_btn_ManualPayment")).click();
         WebElement e=driver.findElement(By.id("trackingNumberLabel"));
         assertNotNull(e);
     }
     @Test
     public void testNewTab(){
         driver.get("http://www.google.com");
         String h1=driver.getWindowHandle();
         ((JavascriptExecutor)driver).executeScript("window.open()");
         driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
         driver.get("http://www.ibm.com");
     }
     @Test
     public void testGithub() throws InterruptedException{
         driver.get("http://nlilaramani.github.io/frame.html");
         driver.findElement(By.xpath("//button")).click();
         Thread.sleep(3000);
         Alert alert=driver.switchTo().alert();
         alert.accept();
         driver.switchTo().frame("iframe_1").findElement(By.id("fname")).sendKeys("Narendra");
     }
     
     @Test
     public void testUserprofile(){
         driver.get("http://nlilaramani.github.io/userprofile.html");
         //driver.findElement(By.xpath("//button")).click();
         driver.findElements(By.name("g")).get(1).click();
         WebElement e=driver.findElement(By.xpath("//select"));
         Select s=new Select(e);
         s.selectByIndex(2);
         e.submit();
     }
     
     @Test
     public void testData() throws FileNotFoundException, IOException{
         Workbook wb=new XSSFWorkbook(new FileInputStream(new File("c:\\qa\\data.xlsx")));
        Sheet sh=wb.getSheetAt(0);
        String fname=sh.getRow(0).getCell(0).getStringCellValue();
        String lname=sh.getRow(0).getCell(1).getStringCellValue();
        driver.get("http://nlilaramani.github.io/userprofile.html");
        driver.findElement(By.id("fname")).sendKeys(fname);
        driver.findElement(By.name("lname")).sendKeys(lname);
        
     }
     
}
