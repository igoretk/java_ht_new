package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.PhoneInfoData;
import ru.stqa.hometask.addressbook.model.PrimaryInfoData;
import ru.stqa.hometask.addressbook.model.SecondaryInfoData;

public class ContactTestDelete extends TestBase {
  @Test
  public void testContactDelete() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    int beforeContactCounter = applicationManager.getContactHelper().getContactCount();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new PrimaryInfoData("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field"),
                      new PhoneInfoData("123121", "21321321", "321321321", "32112"),
                      new SecondaryInfoData("secondary address bla bla bla", "additional info I love cats"));

    }
    applicationManager.getContactHelper().selectContact(0);
    applicationManager.getContactHelper().deleteContact();
    applicationManager.getContactHelper().getBackHomePage();
    int afterContactCounter = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter - 1);


  }
}
