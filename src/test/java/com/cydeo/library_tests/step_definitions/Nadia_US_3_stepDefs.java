package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.pages.BookPage;
import com.cydeo.library_tests.utilities.BrowserUtils;
import com.cydeo.library_tests.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Nadia_US_3_stepDefs {

        BookPage bookPage=new BookPage();
        List<String> actualCategoryList;

        List <String> listOfCategoriesUI;
        List <String>  listOfCategoriesDB;

        @When("I take all book categories in UI")
        public void i_take_all_book_categories_in_ui() {

            BrowserUtils.waitFor(3);
            listOfCategoriesUI= BrowserUtils.getAllSelectOptions(bookPage.selectCategories);
            listOfCategoriesUI.remove(0);
            System.out.println("listOfCategoriesUI = " + listOfCategoriesUI);
        }

        @When("I execute query to get book categories")
        public void i_execute_query_to_get_book_categories() {
            String query=  "select name from book_categories";
            DB_Util.runQuery(query);
            listOfCategoriesDB = DB_Util.getColumnDataAsList(1);
            System.out.println("listOfCategoriesDB = " + listOfCategoriesDB);

        }

        @Then("verify book categories must match book_categories table from db")
        public void verify_book_categories_must_match_book_categories_table_from_db() {

            Assert.assertEquals(listOfCategoriesUI, listOfCategoriesDB );

        }

    }

