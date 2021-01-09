/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author itexps
 */
public class LoginPage {
    private WebDriver driver;
    private WebElement username;
    private WebElement password;
    private WebElement button;
    
    public LoginPage(WebDriver driver){
        this.driver=driver;
        username=driver.findElement(By.name("username"));
        password=driver.findElement(By.name("password"));
        button=driver.findElement(By.id("sign_in_btnundefined"));
    }
    public boolean login(String username, String pwd){
        this.username.sendKeys(username);
        this.password.sendKeys(pwd);
        button.click();
        return true;
    }
    public boolean loginWithFacebook(String username, String pwd){
        return true;
    }
}
