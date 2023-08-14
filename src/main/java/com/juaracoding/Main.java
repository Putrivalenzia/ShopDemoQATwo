package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account/");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        CartPage cartPage = new CartPage();
        cartPage.addToCart();

        CheckoutPage checkoutPage = new CheckoutPage();

        // Skenario Tes Positif
        checkoutPage.proceedCheckout("putri", "val", "Leni Residence", "Jakarta Pusat", "10260", "082258194035", "putrivalenzia14@gmail.com", "DKI Jakarta", "ID");
        System.out.println("Order Success!");

        CartPage cartPageTwo = new CartPage();
        cartPageTwo.addToCart();

        // Skenario Tes Negatif
        checkoutPage.proceedCheckout("", "val", "Leni Residence", "Jakarta Pusat", "10260", "082258194035", "putrivalenzia14@gmail.com", "DKI Jakarta", "ID");
        System.out.println("First Name required");


        driver.quit();

        DriverSingleton.delay(0);
        DriverSingleton.closeObjectInstance();
    }
}