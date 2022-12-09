package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.pages.BookPage;
import com.cydeo.library_tests.pages.DashBoardPage;
import com.cydeo.library_tests.utilities.BrowserUtils;
import com.cydeo.library_tests.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TS13_160_VeryfyStudentAbleBorrowBook {


    BookPage bookPage = new BookPage();
//    @Given("I login as a student")
//    public void i_login_as_a_student() {
//        new LoginPage().login("student38@library", "KcD0IURm");
//    }


    String borrowBookName = "";
    @Given("I search book name called {string} k")
    public void i_search_book_name_called(String bookName) {

        borrowBookName = bookName;
        BrowserUtils.waitFor(2);
        bookPage.inputSearch.sendKeys(bookName);
        BrowserUtils.waitFor(2);

    }

    @When("I click Borrow Book k")
    public void i_click_borrow_book() {
        for (WebElement eachBook : bookPage.borrowBookButtons)
        if (eachBook.getAttribute("class").equals("btn btn-primary btn-sm  ")) {
            eachBook.click();
            break;
        }
    }

    @Then("verify that book is shown in {string} page k")
    public void verify_that_book_is_shown_in_page(String moduleName) {

        new DashBoardPage().navigateModule(moduleName);
    }

    @Then("verify logged student has same book in database k")
    public void verify_logged_student_has_same_book_in_database() {
        BrowserUtils.waitFor(2);
        String quere = "select full_name,b.name,bb.borrowed_date from users u\n" +
                "                                                  inner join book_borrow bb on u.id = bb.user_id\n" +
                "                                                  inner join books b on bb.book_id = b.id\n" +
                "where full_name='Test Student 38'\n" +
                "order by 3 desc;";

        DB_Util.runQuery(quere);

        Assert.assertTrue(DB_Util.getColumnDataAsList(2).contains(borrowBookName));
        for (String s : DB_Util.getColumnDataAsList(2)) {
            System.out.println(s);

        }

    }
}
