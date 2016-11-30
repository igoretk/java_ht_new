package ru.stqa.hometask.addressbook.tests;

import java.sql.*;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;
import ru.stqa.hometask.addressbook.model.Groups;

public class DbConnectionTest {
  @Test
  public void testDbConnection() {

    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?serverTimezone=UTC&user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
      Groups groups = new Groups();

      while (rs.next()) {
        groups.add(new DataGroupFilling()
                .withId(rs.getInt("group_id")).withGroupName(rs.getString("group_name")).withGroupHeader(rs.getString("group_header")).withGroupFooter(rs.getString("group_footer")));
      }

      rs.close();
      st.close();
      conn.close();

      System.out.println(groups);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}