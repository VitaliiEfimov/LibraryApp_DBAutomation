package com.cydeo.library_tests.pages;

import com.cydeo.library_tests.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * parent class for concrete Page object classes
 * provides constructor with initElements method for re-usability
 * abstract - to prevent instantiation.
 */
public abstract  class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//span[normalize-space()='Users']")
    public WebElement users;

    @FindBy(xpath = "//span[normalize-space()='Books']")
    public WebElement books;

    @FindBy(xpath = "//a[@id='navbarDropdown']")
    public WebElement dropdownBar;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logoutButton;

    public void logOut(){
        dropdownBar.click();
        logoutButton.click();
    }

    public void navigateModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("//span[@class='title'][.='"+moduleName+"']")).click();
    }
}


