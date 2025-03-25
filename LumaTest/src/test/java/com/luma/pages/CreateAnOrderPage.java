package com.luma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnOrderPage {
    @FindBy(xpath = "//span[text()=\"Create New Customer Account\"]")
    public WebElement Header_CreateNewCustomerAccount;

    @FindBy(id = "firstname")
    public WebElement Textbox_FirstName;

    @FindBy(id = "lastname")
    public WebElement Textbox_LastName;
}
