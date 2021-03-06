package com.kodilla.jdbc;

import com.kodilla.jdbc.DbManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    @Test
    public void testConnection() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        //when
        //then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuerry = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuerry);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + " ," + rs.getString("FirstName") + " , "
                    + rs.getString("LastName"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        //when
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT FIRSTNAME , LASTNAME , COUNT(*) AS NR\n" +
                "FROM USERS AS U\n" +
                "JOIN POSTS AS P\n" +
                "ON U.ID = P.USER_ID\n" +
                "GROUP BY U.ID\n" +
                "HAVING NR>=2;");
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + " , " + rs.getString("LASTNAME"));
            counter++;
        }
        statement.close();
        rs.close();
        Assert.assertEquals(1, counter);


    }
}
