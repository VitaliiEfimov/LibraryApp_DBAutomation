package com.cydeo.library_tests.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookPage extends BasePage {


    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;


    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;



    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }





}


    @FindBy (xpath = "//a[.=' Add Book']")

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
    public List<WebElement> bookNameInTable;

    @FindBy (xpath = "//table[@id='tbl_books']/tbody/tr/td[1]/a")
    public List<WebElement> borrowBookButtons;


    @FindBy(xpath = "//*[@id=\"tbl_books\"]//thead//tr//th[7]")
    public WebElement borrowedBy;

    @FindBy(xpath = "//*[@id=\"borrowed_list\"]/tbody/tr[27]/td[6]")
    public WebElement NotReturned;

    @FindBy(xpath = "//*[@id='menu_item']//li[2]//a//span[1]")
    public WebElement borrowingBooks;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm  ']")
    public WebElement borrowBookBtn;

   @FindBy (id = "book_categories")
    public WebElement selectCategories;

}


