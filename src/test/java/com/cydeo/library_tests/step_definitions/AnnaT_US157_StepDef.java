package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.pages.BookPage;
import com.cydeo.library_tests.pages.LoginPage;
import com.cydeo.library_tests.utilities.BrowserUtils;
import com.cydeo.library_tests.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AnnaT_US157_StepDef {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    String book = "";


    @Given("I login as a student")
    public void i_login_as_a_student() {
        loginPage.login("student38@library", "nca2fAGL");
        BrowserUtils.waitFor(2);

    }
    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {


    }

    @Given("I search book name called {string}")
    public void i_search_book_name_called(String bookName) {
        book = bookName;
        bookPage.inputSearch.click();
        bookPage.inputSearch.sendKeys(book);
        BrowserUtils.waitFor(2);

    }
    @When("I click Borrow Book")
    public void i_click_borrow_book() {
        bookPage.borrowedBy.click();
        BrowserUtils.waitFor(2);
        bookPage.borrowBookBtn.click();

    }

    @Then("verify that book is shown in {string} page")
    public void verifyThatBookIsShownInPage(String borrowing) {
        BrowserUtils.waitFor(2);
        bookPage.borrowingBooks.click();
        bookPage.NotReturned.isDisplayed();

    }


    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        BrowserUtils.waitFor(2);


DB_Util.runQuery("select b.name from books b inner join book_borrow bbr on b.id = bbr.book_id\n" +
        "    inner join users u on u.id = bbr.user_id where full_name = 'Test Student 38'\n" +
        "    and is_returned = 'NOT RETURNED'\n" +
        "and b.name = 'Head First Java'");



        String expectedBorrowedBook = DB_Util.getFirstRowFirstColumn();
        //Compare
        Assert.assertEquals(expectedBorrowedBook,book);



    }

}
