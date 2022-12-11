package com.cydeo.library_tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookPage extends BasePage {
    @FindBy(xpath = "//a[.=' Add Book']")
    public WebElement addBookButton;

    @FindBy (xpath = "//input[@name='name']")
    public WebElement inputBookName;

    @FindBy (xpath = "//input[@name='isbn']")
    public WebElement inputBookIsbn;

    @FindBy (xpath = "//input[@name='year']")
    public WebElement inputBookYear;

    @FindBy (xpath = "//input[@name='author']")
    public WebElement inputBookAuthor;

    @FindBy (xpath = "//select[@id='book_group_id']")
    public WebElement selectBookGroup;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement saveChangesButton;

    @FindBy (xpath = "//input[@type='search']")
    public WebElement inputSearch;

    @FindBy (xpath = "//table[@id='tbl_books']/tbody/tr/td[3]")
    public WebElement bookNameInTable;

    @FindBy (xpath = "//table[@id='tbl_books']/tbody/tr/td[1]/a")
    public List<WebElement> borrowBookButtons;

}

