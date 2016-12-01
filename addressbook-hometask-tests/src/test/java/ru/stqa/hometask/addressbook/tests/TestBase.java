package ru.stqa.hometask.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.hometask.addressbook.appmanager.ApplicationManager;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;
import ru.stqa.hometask.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }
  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new DataGroupFilling().withId(g.getId()).withGroupName(g.getGroupName()))
              .collect(Collectors.toSet())));
    }
  }
}
