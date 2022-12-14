package com.cydeo.library_tests.step_definitions;
import com.cydeo.library_tests.pages.LoginPage;
import com.cydeo.library_tests.pages.TS13_156Page;

import com.cydeo.library_tests.utilities.BrowserUtils;
import com.cydeo.library_tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class TS13_156 {


    TS13_156Page ts13_156Page=new TS13_156Page();
    LoginPage loginPage=new LoginPage();

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
        BrowserUtils.waitFor(2);
      ts13_156Page.emailBox.sendKeys("librarian5@library");
     ts13_156Page.passwordBox.sendKeys("hj65YBiE");
     //  new LoginPage().login("librarian5@library", "hj65YBiE");



    }

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String booksPage) {
    ts13_156Page.sighInButton.click();

    }

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
    ts13_156Page.book.click();
    ts13_156Page.addBookButton.click();

    }

    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        ts13_156Page.bookName.sendKeys(bookName);
        BrowserUtils.waitFor(2);


    }

    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {
     ts13_156Page.isbn.sendKeys(isbn);
        BrowserUtils.waitFor(2);

    }

    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
        ts13_156Page.year.sendKeys(year);
        BrowserUtils.waitFor(2);

    }

    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
    ts13_156Page.author.sendKeys(author);
        BrowserUtils.waitFor(2);

    }

    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {
        Select select=new Select(ts13_156Page.bookCategory);
       select.selectByVisibleText(bookCategory);
        BrowserUtils.waitFor(2);

    }

    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
     ts13_156Page.saveChangesButton.click();
        BrowserUtils.waitFor(2);



    }

    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String string) {

    }

    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String string) {




        Driver.closeDriver();
    }


    }

