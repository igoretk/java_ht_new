package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.hometask.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager applicationManager = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    applicationManager.init();

  }

  @AfterMethod
  public void tearDown() {
    applicationManager.stop();
  }

}
