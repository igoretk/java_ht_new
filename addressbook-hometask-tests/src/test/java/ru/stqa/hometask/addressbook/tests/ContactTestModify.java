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
    app.goTo().gotoHomePageForContactCreation();
    if (!app.getContactHelper().isAnyContactThere()) {
      app.getContactHelper().
              createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));

    }
    int beforeContactCounter = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(beforeContactCounter - 1);
    app.getContactHelper().selectToEditContactPrimaryInfo();
    app.getContactHelper().fillingTheForms(new DataContactFilling("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"));
    app.getContactHelper().submitEditContact();
    app.getContactHelper().getBackHomePage();
    int afterContactCounter = app.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter);

  }

  @Test
  public void testContactModifyWithCollectionSortedLists() {
    app.goTo().gotoHomePageForContactCreation();
    if (!app.getContactHelper().isAnyContactThere()) {
      app.getContactHelper().
              createContact(new DataContactFilling("1", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));
    }
    int beforeContactCounter = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(beforeContactCounter - 1);
    app.getContactHelper().selectToEditContactPrimaryInfo();
    app.getContactHelper().fillingTheForms(new DataContactFilling("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"));
    app.getContactHelper().submitEditContact();
    app.getContactHelper().getBackHomePage();
    int afterContactCounter = app.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter);

  }

  @Test
  public void testContactModifyWithHashSet() {
    app.goTo().gotoHomePageForContactCreation();
    if (!app.getContactHelper().isAnyContactThere()) {
      app.getContactHelper().
              createContact(new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null));
    }
    List<DataContactFilling> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().selectToEditContactPrimaryInfo();
    DataContactFilling contact = new DataContactFilling(before.get(before.size() - 1).getId(), "1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.getContactHelper().fillingTheForms(contact);
    app.getContactHelper().submitEditContact();
    app.getContactHelper().getBackHomePage();
    List<DataContactFilling> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
  @Test
  public void testContactModifyWithHashSetWithSort() {
    app.goTo().gotoHomePageForContactCreation();
    if (!app.getContactHelper().isAnyContactThere()) {
      app.getContactHelper().
              createContact(new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null));
    }
    List<DataContactFilling> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().selectToEditContactPrimaryInfo();
    DataContactFilling contact = new DataContactFilling(before.get(before.size() - 1).getId(), "1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.getContactHelper().fillingTheForms(contact);
    app.getContactHelper().submitEditContact();
    app.getContactHelper().getBackHomePage();
    List<DataContactFilling> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    Comparator<? super DataContactFilling> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
