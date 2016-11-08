package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.PhoneInfoData;
import ru.stqa.hometask.addressbook.model.PrimaryInfoData;
import ru.stqa.hometask.addressbook.model.SecondaryInfoData;

public class ContactTestModify extends TestBase{
  @Test
  public void testContactModify() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    int beforeContactCounter = applicationManager.getContactHelper().getContactCount();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new PrimaryInfoData("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field"),
                      new PhoneInfoData("123121", "21321321", "321321321", "32112"),
                      new SecondaryInfoData("secondary address bla bla bla", "additional info I love cats"));

    }
    applicationManager.getContactHelper().selectContact(beforeContactCounter - 1);
    applicationManager.getContactHelper().selectToEditContactPrimaryInfo();
    applicationManager.getContactHelper().primaryInfoFill(new PrimaryInfoData("1", "2", "3", "4", null, "6", null));
    applicationManager.getContactHelper().submitEditContact();
    applicationManager.getContactHelper().getBackHomePage();
    int afterContactCounter = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter);

  }
}
