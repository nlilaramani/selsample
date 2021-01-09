/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.train;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author itexps
 */
public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get("http://advantageonlineshopping.com/#/");
    }
    public LoginPage getLogin(){
        driver.findElement(By.id("hrefUserIcon")).click();
        return new LoginPage(driver);
    }
}
