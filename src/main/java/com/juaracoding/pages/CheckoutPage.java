package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.juaracoding.drivers.DriverSingleton.delay;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //Locator Find By
    @FindBy(linkText = "PROCEED TO CHECKOUT")
    WebElement btnCheckout;
    @FindBy(id = "billing_first_name")
    WebElement firstName;
    @FindBy(id = "billing_last_name")
    WebElement lastName;
    @FindBy(id = "billing_country")
    WebElement selectCountry;
    @FindBy(id = "billing_address_1")
    WebElement address;
    @FindBy(id = "billing_city")
    WebElement city;
    @FindBy(id = "billing_state")
    WebElement state;
    @FindBy(id = "billing_postcode")
    WebElement postCode;
    @FindBy(id = "billing_phone")
    WebElement phone;
    @FindBy(id = "billing_email")
    WebElement email;
    @FindBy(id = "terms")
    WebElement checkTerms;
    @FindBy(id = "place_order")
    WebElement btnPlaceOrder;

    @FindBy(xpath = "/html/body/div[1]/div[2]/main/article/div/div/form[2]/div[1]/ul/li[1]")
    WebElement errorMsg;


    public void proceedCheckout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        btnCheckout.click();
        firstName.clear();
        js.executeScript("window.scrollBy(0,500)");
        delay(5);
        btnPlaceOrder.click();
        String errorMessage = errorMsg.getText();


        if (errorMessage.equals("Billing First name is a required field.")) {
            System.out.println("Tes case negatif berhasil");
        } else {
            System.out.println("Tes case negatif gagal");
        }


        firstName.clear();
        firstName.sendKeys("putri");
        lastName.clear();
        lastName.sendKeys("val");


        js.executeScript("window.scrollBy(0,500)");
        Select selectCountry = new Select(this.selectCountry);
        selectCountry.selectByValue("ID");

        address.clear();
        address.sendKeys("Leni Residence");
        city.clear();
        city.sendKeys("Jakarta Pusat");

        Select selectState = new Select(state);
        selectState.selectByVisibleText("DKI Jakarta");

        postCode.clear();
        postCode.sendKeys("10260");
        phone.clear();
        phone.sendKeys("082258194035");
        email.clear();
        email.sendKeys("putrivalenzia14@gmail.com");
        checkTerms.click();
        btnPlaceOrder.click();
        System.out.println("Order Success!");


    }

}
