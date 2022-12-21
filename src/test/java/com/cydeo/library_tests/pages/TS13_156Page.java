package com.cydeo.library_tests.pages;
import com.cydeo.library_tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class TS13_156Page extends BasePage {

 public TS13_156Page() {

     PageFactory.initElements(Driver.getDriver(), this);
 }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;


    @FindBy(id = "inputPassword")
    public WebElement passwordBox;


    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement sighInButton;

    @FindBy(xpath = "//span[.='Books']")
    public WebElement book;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    public WebElement addBookButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement bookName;

    @FindBy(xpath = "//input[@name='isbn']")
    public WebElement isbn;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement year;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement author;

    @FindBy(id = "book_group_id")
    public WebElement bookCategory;

     @FindBy(xpath = "//button[.='Save changes']")
    public WebElement saveChangesButton;






}



