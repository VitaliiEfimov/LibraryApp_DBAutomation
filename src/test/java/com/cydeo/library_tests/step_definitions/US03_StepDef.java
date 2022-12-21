package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.pages.*;
import com.cydeo.library_tests.utilities.BrowserUtils;
import com.cydeo.library_tests.utilities.ConfigurationReader;
import com.cydeo.library_tests.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_StepDef {
    LoginPage loginPage=new LoginPage();
  String email;
  String actualUserName;

   BookPage bookPage=new BookPage();
    List<String> actualCategoryList;
    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {

          String url = ConfigurationReader.getProperty("library_url");
           String userName = ConfigurationReader.getProperty("librarian_username");
          String password = ConfigurationReader.getProperty("password");
          DB_Util.createConnection(url, userName,password);
    }
    @When("I navigate to {string} page")
    public void i_navigate_to_page(String moduleName) {
       // new DashBoardPage().navigateModule(moduleName);

   }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        actualCategoryList=BrowserUtils.getAllSelectOptions(bookPage.mainCategoryElement);
       actualCategoryList.remove(0);
      System.out.println("actualCategoryList = " + actualCategoryList);
    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db(List<String> expectedCategoryList) {
        Assert.assertEquals(expectedCategoryList, actualCategoryList);
    }
    }
    //


