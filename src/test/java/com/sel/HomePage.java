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
public class HomePage {
    private WebDriver driver;
    private WebElement signInLink;
    private WebElement searchLink;
    private WegElement searchText;
    
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get("http://advantageonlineshopping.com/#/");
        signInLink=driver.findElement(By.id("hrefUserIcon"));
        searchLink=driver.findElement(By.id("menusSearch"));
        searchText=driver.findElement(By.id("searchBox"));
    }
    public LoginPage getSignin(){
        signInLink.click();
        return new LoginPage(driver);
    }
    public ProductListPage  search(String criteria){
        searchLink.click();
        searchText.sendKeys(criteria);
        return new ProductListPage(driver);
    }
}
