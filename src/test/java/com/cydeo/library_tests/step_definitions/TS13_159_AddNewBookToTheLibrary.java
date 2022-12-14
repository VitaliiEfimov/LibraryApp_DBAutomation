package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.pages.BookPage;
import com.cydeo.library_tests.pages.LoginPage;
import com.cydeo.library_tests.utilities.BrowserUtils;
import com.cydeo.library_tests.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class TS13_159_AddNewBookToTheLibrary {

    BookPage bookPage = new BookPage();

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        // Test Librarian 7	librarian7@library	OEeZbJjV
        new LoginPage().login("librarian7@library", "OEeZbJjV");

        BrowserUtils.waitFor(2);
    }

//    @Given("I navigate to {string} page")
//    public void i_navigate_to_page(String moduleName) {
//        new DashBoardPage().navigateModule(moduleName);
//
//    }

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        bookPage.addBookButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {

        bookPage.inputBookName.sendKeys(bookName);
    }

    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {

        bookPage.inputBookIsbn.sendKeys(isbn);
    }

    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {

        bookPage.inputBookYear.sendKeys(year);
    }

    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {

        bookPage.inputBookAuthor.sendKeys(author);
    }

    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String categoryName) {

        Select select = new Select(bookPage.selectBookGroup);
        select.selectByVisibleText(categoryName);
        BrowserUtils.waitFor(2);


    }

    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

        bookPage.saveChangesButton.click();
    }

    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String expectedBookName) {

        BrowserUtils.waitFor(2);
        bookPage.inputSearch.sendKeys(expectedBookName);
        BrowserUtils.waitFor(2);


        String actualBookName = bookPage.bookNameInTable.get(0).getText();
        System.out.println("actualBookName = " + actualBookName);
        System.out.println("expectedBookName = " + expectedBookName);

        Assert.assertEquals(expectedBookName, actualBookName);
    }

    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String bookName) {

        String query = "select id,name,author from books\n" +
                "where name = '" + bookName + "' order by id desc;";
        DB_Util.runQuery(query);

        String expectedName = DB_Util.getCellValue(1, 2);
        System.out.println("expectedName = " + expectedName);

        Assert.assertEquals(expectedName, bookName);
    }

}
