package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;

    public CartPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    // Locator @FindBy

    @FindBy(className = "custom-logo")
    WebElement productPage;

    @FindBy(linkText = "TOKYO TALKIES")
    WebElement product;

    @FindBy(linkText = "BLACK CROSS BACK MAXI DRESS")
    WebElement productTwo;

    @FindBy(id = "pa_color")
    WebElement selectColor;


    @FindBy(id = "pa_size")
    WebElement selectSize;


    @FindBy(className = "single_add_to_cart_button")
    WebElement btnAddToCart;

    @FindBy(className = "icon_bag_alt")
    WebElement btnCart;


    // Custom Method
    public void addToCart() {

        productPage.click();
        product.click();
        btnAddToCart.click();
        btnCart.click();

        productPage.click();
        productTwo.click();
        selectColor.click();
        Select select = new Select(selectColor);
        select.selectByValue("beige");
        selectSize.click();
        Select selectTwo = new Select(selectSize);
        selectTwo.selectByValue("medium");
        btnAddToCart.click();
        btnCart.click();

        // Buat assert menggunakan if
        // Cek apakah ada elemen dengan class "cart-empty"
        if (driver.findElements(By.className("cart-empty")).isEmpty()) {
            System.out.println("Add to Cart Berhasil");
        } else {
            System.out.println("Add to Cart Gagal");
        }


    }

}

