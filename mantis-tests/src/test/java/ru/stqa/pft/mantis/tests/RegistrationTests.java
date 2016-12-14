package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by bebeka on 06.12.2016.
 */
public class RegistrationTests extends TestBase {

  //  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test(enabled = false)
  public void testRegistration() throws IOException, MessagingException {
    long now = System.currentTimeMillis();
    String user = String.format("user%s", now);
    String password = "password";
    String email = String.format("user%s@localhost.localdomain", now);
    app.james().createUser(user, password);

    app.registration().start(user, email);
    //List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);

    List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);

    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));

  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


  // @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

  @Test
  public void testResetPsw() throws IOException, MessagingException, SQLException {

    String strForConnection = "jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=";
    HashSet<Users> bugTrackerUsers = new HashSet<>();
    Connection connection;
    String password = "changedPSW";


    connection = DriverManager.getConnection(strForConnection);

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select id, username, email from mantis_user_table");
    resultSet = getResultSetChecking(bugTrackerUsers, statement, resultSet);

    app.mail().start();
    app.registration().login("administrator", "root");
    app.goTo().settingsPage();
    app.goTo().settingsUser();
    Users changedUser = bugTrackerUsers.iterator().next();
    app.registration().resetPsw(changedUser.getUserName());
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmLink = findConfirmationLink(mailMessages, changedUser.getEmail());
    app.registration().logout();
    app.registration().finish(confirmLink, password);
    assertTrue(app.newSession().login(changedUser.getUserName(), password));
    app.mail().stop();
    stopConnectionActivity(connection, statement, resultSet);

  }

  private ResultSet getResultSetChecking(HashSet<Users> bugTrackerUsers, Statement statement, ResultSet resultSet) throws SQLException, IOException, MessagingException {
    while (resultSet.next()) {
      if (!"administrator".equals(resultSet.getString("username"))) {
        bugTrackerUsers.add(new Users(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email")));
      }
    }
    if (bugTrackerUsers.size() == 0) {
      testRegistration();
      resultSet = statement.executeQuery("select id, username, email from mantis_user_table");
      while (resultSet.next()) {
        if (!"administrator".equals(resultSet.getString("username"))) {
          bugTrackerUsers.add(new Users(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email")));
        }
      }
    }
    return resultSet;
  }

  private void stopConnectionActivity(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
    resultSet.close();
    statement.close();
    connection.close();
  }


}
