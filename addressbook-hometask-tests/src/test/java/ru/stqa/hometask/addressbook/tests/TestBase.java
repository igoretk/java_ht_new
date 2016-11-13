package ru.stqa.hometask.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.hometask.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager applicationManager = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    applicationManager.init();

  }

  @AfterSuite
  public void tearDown() {
    applicationManager.stop();
  }

}
