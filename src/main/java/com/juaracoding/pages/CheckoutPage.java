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


    public void proceedCheckout(String firstNameValue, String lastNameValue, String addressValue, String cityValue, String postCodeValue, String phoneValue, String emailValue, String stateValue, String countryValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        btnCheckout.click();
        firstName.clear();
        firstName.sendKeys(firstNameValue);
        lastName.clear();
        lastName.sendKeys(lastNameValue);


        js.executeScript("window.scrollBy(0,500)");
        Select selectCountry = new Select(this.selectCountry);
        selectCountry.selectByValue(countryValue);

        address.clear();
        address.sendKeys(addressValue);
        city.clear();
        city.sendKeys(cityValue);

        Select selectState = new Select(state);
        selectState.selectByVisibleText(stateValue);
        js.executeScript("window.scrollBy(0,500)");
        postCode.clear();
        postCode.sendKeys(postCodeValue);
        phone.clear();
        phone.sendKeys(phoneValue);
        email.clear();
        email.sendKeys(emailValue);
        checkTerms.click();
        btnPlaceOrder.click();
        delay(2);


    }


}
