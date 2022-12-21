package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US_03_Step_Def {
LoginPage loginPage = new LoginPage();
    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
     loginPage.login("librarian");
    }
    @When("I navigate to {string} page")
    public void i_navigate_to_page(String string) {

    }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {

    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

    }

}
