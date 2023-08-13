package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Locator @FindBy
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(name = "login")
    WebElement btnLogin;

    // Custom Method
    public void login(){
        username.sendKeys("putri");
        password.sendKeys("999Putri!");
        btnLogin.click();

        if (driver.findElements(By.className("woocommerce-error")).isEmpty()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

    }
}

