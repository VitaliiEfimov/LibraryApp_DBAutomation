package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.pages.BookPage;
import com.cydeo.library_tests.pages.DashBoardPage;
import com.cydeo.library_tests.pages.LoginPage;
import com.cydeo.library_tests.utilities.BrowserUtils;
import com.cydeo.library_tests.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

    public class Nadia_US_4_StepDefs {
        BookPage bookPage=new BookPage();
        List<String> actualCategoryList = new ArrayList<>();
        LoginPage loginPage=new LoginPage();

//        @Given("I login as a librarian")
//        public void i_login_as_a_librarian() {
//            loginPage.login("librarian");
//        }
//
        @Given("I navigate to {string} page n")
        public void i_navigate_to_page(String moduleName) {

            BrowserUtils.waitFor(2);
            new DashBoardPage().navigateModule(moduleName);

        }

        @When("I open book {string}")
        public void i_open_book(String bookName) {

            System.out.println("bookName = " + bookName);
            BrowserUtils.waitForClickability(bookPage.inputSearch, 1).sendKeys(bookName);
//            BrowserUtils.waitForClickability(bookPage.editBook(bookName), 1).click();
        }

        @Then("book information must match the Database")
        public void book_information_must_match_the_database() {

            String query="select name, author, year from books where name='Chordeiles minor';";

            //run query to get all categories from Database
            DB_Util.runQuery(query);

            BrowserUtils.waitFor(2);
            System.out.println("From DB" + DB_Util.getCellValue(1, 1));
            BrowserUtils.waitFor(2);

            //store data
            List<String> expectedCategoryList = DB_Util.getColumnDataAsList(1);
            System.out.println("expectedCategoryList = " + expectedCategoryList);

            for (WebElement eachBookName : bookPage.bookNameInTable) {
                actualCategoryList.add(eachBookName.getText());
            }
            System.out.println("actualCategoryList = " + actualCategoryList);
            // Assertions
            Assert.assertEquals(expectedCategoryList, actualCategoryList);

        }
    }


