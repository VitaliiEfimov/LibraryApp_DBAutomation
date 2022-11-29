package com.cydeo.library_tests.pages;

import com.cydeo.library_tests.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class=\"button nav__item active\"]")
    public WebElement viewAllOrdersNavItemButton;

    @FindBy(xpath = "/html/body/div[1]/nav/div[2]/a[2]/button")
    public WebElement viewAllProductsNavItemButton;

    @FindBy(xpath = "/html/body/div[1]/nav/div[2]/a[3]/button")
    public WebElement orderNavItemButton;

    @FindBy(xpath = "//button[@class=\"button __logout\"]")
    public WebElement logoutButton;

}
