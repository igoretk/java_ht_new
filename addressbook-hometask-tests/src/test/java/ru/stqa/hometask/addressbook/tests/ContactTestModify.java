package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.PrimaryInfoData;

public class ContactTestModify extends TestBase{
  @Test
  public void testContactModify() {
    applicationManager.getContactHelper().selectContact();
    applicationManager.getContactHelper().selectToEditContactPrimaryInfo();
    applicationManager.getContactHelper().primaryInfoFill(new PrimaryInfoData("1", "2", "3", "4", "5", "6", "7"));
    applicationManager.getContactHelper().submitEditContact();

  }
}
