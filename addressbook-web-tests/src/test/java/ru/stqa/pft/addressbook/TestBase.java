package ru.stqa.pft.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
