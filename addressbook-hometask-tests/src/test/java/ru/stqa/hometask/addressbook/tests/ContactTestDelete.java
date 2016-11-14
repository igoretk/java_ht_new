package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.List;

public class ContactTestDelete extends TestBase {
  @Test
  public void testContactDelete() {
    app.goTo().gotoHomePageForContactCreation();
    if (!app.getContactHelper().isAnyContactThere()) {
      app.getContactHelper().
              createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));

    }
    int beforeContactCounter = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteContact();
    app.getContactHelper().getBackHomePage();
    int afterContactCounter = app.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter - 1);
  }

  @Test
  public void testContactDeleteWithCollections() {
    app.goTo().gotoHomePageForContactCreation();
    if (!app.getContactHelper().isAnyContactThere()) {
      app.getContactHelper().
              createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));

    }
    List<DataContactFilling> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().getBackHomePage();
    List<DataContactFilling> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }
}
