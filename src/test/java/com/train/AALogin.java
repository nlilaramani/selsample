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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author itexps
 */
public class AALogin {
    
    public AALogin() {
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
    @Test
    public void testLogin() {
        driver.get("http://advantageonlineshopping.com/#/");
        driver.findElement(By.id("hrefUserIcon")).click();
        driver.findElement(By.name("username")).sendKeys("nltest");
        driver.findElement(By.name("password")).sendKeys("Abc@1239");
        driver.findElement(By.id("sign_in_btnundefined")).click();
        driver.findElement(By.xpath("//a[@id='menuUserLink']/span")).click();
        driver.findElement(By.xpath("//div[@id='loginMiniTitle']/label[3]")).click();
        //driver.findElement(By.id("//label[@translate='Sign_out']")).click();

    }
    
    @Test
    public void testDataDrivenLogin() throws FileNotFoundException, IOException, InterruptedException{
        FileInputStream fs=new FileInputStream(new File("c:\\qa\\aa.xlsx"));
        Workbook wb=new XSSFWorkbook(fs);
        Sheet sh=wb.getSheetAt(0);
        driver.get("http://advantageonlineshopping.com/#/");
        for(int i=1;i<=2;i++){
        driver.findElement(By.id("hrefUserIcon")).click();
        String uname=sh.getRow(i).getCell(0).getStringCellValue();
        String pwd=sh.getRow(i).getCell(1).getStringCellValue();
        driver.findElement(By.name("username")).sendKeys(uname);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("sign_in_btnundefined")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUserLink")));

        driver.findElement(By.xpath("//div[@id='loginMiniTitle']/label[3]")).click();
        Thread.sleep(5000);
        }
        fs.close();
    }
    
    @Test
    public void testLoginPageObject(){
        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=homePage.getLogin();
        loginPage.login("nltest", "Abc@1239");
    }
}
