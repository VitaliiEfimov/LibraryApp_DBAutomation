package com.cydeo.library_tests.step_definitions;

import com.cydeo.library_tests.utilities.ConfigurationReader;
import com.cydeo.library_tests.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;


public class US05_GenreMostBorrowed_StepDef {

//    String dbUrl = ConfigurationReader.getProperty("dbUrlLibrary3");
//    String dbUsername = ConfigurationReader.getProperty("dbUsernameLibrary3");
//    String dbPassword = ConfigurationReader.getProperty("dbPasswordLibrary3");
//
//    Connection conn;
//    ResultSet rs;
//    Statement statement;
    String actual;

    @Given("Establish the database connection")
    public void establish_the_database_connection() throws SQLException {

//        DB_Util.createConnection(dbUrl,dbUsername,dbPassword);
        DB_Util.createConnectionConfigProp(1);

    }

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() throws SQLException {

        DB_Util.runQuery("select bc.name, count(*)\n" +
                "from book_borrow bb\n" +
                "         inner join books b on bb.book_id = b.id\n" +
                "         inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by name\n" +
                "order by 2 desc");
        actual = DB_Util.getFirstRowFirstColumn();
        System.out.println("actual+string = " + actual);

    }

    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String string) {
        System.out.println("actual+string = " + actual + string);
        Assertions.assertEquals(string,actual);

    }

//    @Test
//    public void US05() throws SQLException {
//        conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//        statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        rs = statement.executeQuery("select bc.name, count(*)\n" +
//                "from book_borrow bb\n" +
//                "         inner join books b on bb.book_id = b.id\n" +
//                "         inner join book_categories bc on b.book_category_id = bc.id\n" +
//                "group by name\n" +
//                "order by 2 desc;");
//        rs.next();
//        actual = rs.getString(1);
//        String expected = "Action and Adventure";
//        System.out.println("actual + expected = " + actual + " + " +expected);
//        Assertions.assertEquals(expected, actual);
//        conn.close();
//        statement.close();
//        rs.close();
//    }
//
//    @Test
//    public void US05_1() throws SQLException {
//        DB_Util.createConnectionConfigProp(1);
//        DB_Util.runQuery("select bc.name, count(*)\n" +
//                "from book_borrow bb\n" +
//                "         inner join books b on bb.book_id = b.id\n" +
//                "         inner join book_categories bc on b.book_category_id = bc.id\n" +
//                "group by name\n" +
//                "order by 2 desc");
//        actual = DB_Util.getFirstRowFirstColumn();
//        System.out.println("actual = " + actual);
//        String expected = "Action and Adventure";
//        System.out.println("actual+string = " + actual + " " + expected);
//        Assertions.assertEquals(expected,actual);
//        DB_Util.destroy();
//    }
}
