package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactTestModify extends TestBase {
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
              createContact(new DataContactFilling("1", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
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
  public void testContactModifyWithHashSet() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null));
    }
    List<DataContactFilling> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getContactHelper().selectContact(before.size() - 1);
    applicationManager.getContactHelper().selectToEditContactPrimaryInfo();
    DataContactFilling contact = new DataContactFilling(before.get(before.size() - 1).getId(), "1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    applicationManager.getContactHelper().fillingTheForms(contact);
    applicationManager.getContactHelper().submitEditContact();
    applicationManager.getContactHelper().getBackHomePage();
    List<DataContactFilling> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
  @Test
  public void testContactModifyWithHashSetWithSort() {
    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    if (!applicationManager.getContactHelper().isAnyContactThere()) {
      applicationManager.getContactHelper().
              createContact(new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null));
    }
    List<DataContactFilling> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getContactHelper().selectContact(before.size() - 1);
    applicationManager.getContactHelper().selectToEditContactPrimaryInfo();
    DataContactFilling contact = new DataContactFilling(before.get(before.size() - 1).getId(), "1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    applicationManager.getContactHelper().fillingTheForms(contact);
    applicationManager.getContactHelper().submitEditContact();
    applicationManager.getContactHelper().getBackHomePage();
    List<DataContactFilling> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    Comparator<? super DataContactFilling> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
