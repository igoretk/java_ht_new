package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;

public class ContactTestDelete extends TestBase {
  @Test
  public void testContactDelete() {
    applicationManager.getContactHelper().selectContact();
    applicationManager.getContactHelper().deleteContact();

  }
}
