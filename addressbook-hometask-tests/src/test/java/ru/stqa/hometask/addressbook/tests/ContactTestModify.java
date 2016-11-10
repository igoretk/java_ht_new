package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

public class ContactTestModify extends TestBase{
  @Test
  public void testContactModify() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));

    }
    int beforeContactCounter = applicationManager.getContactHelper().getContactCount();
    applicationManager.getContactHelper().selectContact(beforeContactCounter - 1);
    applicationManager.getContactHelper().selectToEditContactPrimaryInfo();
    applicationManager.getContactHelper().fillingTheForms(new DataContactFilling("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"));
    applicationManager.getContactHelper().submitEditContact();
    applicationManager.getContactHelper().getBackHomePage();
    int afterContactCounter = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter);

  }
  @Test
  public void testContactModifyWithCollectionSortedLists() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));
    }
    int beforeContactCounter = applicationManager.getContactHelper().getContactCount();
    applicationManager.getContactHelper().selectContact(beforeContactCounter - 1);
    applicationManager.getContactHelper().selectToEditContactPrimaryInfo();
    applicationManager.getContactHelper().fillingTheForms(new DataContactFilling("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"));
    applicationManager.getContactHelper().submitEditContact();
    applicationManager.getContactHelper().getBackHomePage();
    int afterContactCounter = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter);

  }
}
