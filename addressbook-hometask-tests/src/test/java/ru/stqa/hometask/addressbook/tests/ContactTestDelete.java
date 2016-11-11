package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.List;

public class ContactTestDelete extends TestBase {
  @Test
  public void testContactDelete() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));

    }
    int beforeContactCounter = applicationManager.getContactHelper().getContactCount();
    applicationManager.getContactHelper().selectContact(0);
    applicationManager.getContactHelper().deleteContact();
    applicationManager.getContactHelper().getBackHomePage();
    int afterContactCounter = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter - 1);
  }

  @Test
  public void testContactDeleteWithCollections() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));

    }
    List<DataContactFilling> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getContactHelper().selectContact(before.size() - 1);
    applicationManager.getContactHelper().deleteContact();
    applicationManager.getContactHelper().getBackHomePage();
    List<DataContactFilling> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }
}
