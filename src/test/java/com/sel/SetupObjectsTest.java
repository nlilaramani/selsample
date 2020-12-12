/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sel;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class SetupObjectsTest {
    
    public SetupObjectsTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSetupObjects() throws IOException {
        driver.navigate().to("http://www.google.com"); // Load google home page
        driver.navigate().to("http://www.ibm.com"); // Load IBM home page
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().window().setPosition(new Point(0,0));
        driver.navigate().back(); // Go to prev page
        driver.manage().window().maximize(); // Maximize window
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println("File Location:"+srcFile.getAbsolutePath());
        FileUtils.copyFile(srcFile, new File("c:\\qa\\myfile.png"));
    }
}
