package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactTestCreation extends TestBase {

  @Test
  public void testContactCreation() throws InterruptedException {
    app.goTo().gotoHomePageForContactCreation();
    int beforeContactCounter = app.getContactHelper().getContactCount();
    app.getContactHelper().
            createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                    "123121", "21321321", "321321321", "32112",
                    "secondary address bla bla bla", "additional info I love cats"));
    int afterContactCounter = app.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter + 1);

  }

  @Test
  public void testContactCreationWithCollection() {
    app.goTo().gotoHomePageForContactCreation();
    List<DataContactFilling> before = app.getContactHelper().getContactList();
    app.getContactHelper().
            createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                    "123121", "21321321", "321321321", "32112",
                    "secondary address bla bla bla", "additional info I love cats"));
    List<DataContactFilling> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

  }

  @Test
  public void testContactCreationWithCollectionSearchMax() {
    app.goTo().gotoHomePageForContactCreation();
    List<DataContactFilling> before = app.getContactHelper().getContactList();
    DataContactFilling dataContactFilling = new DataContactFilling("1", "2", "3", null, null, null, null, null, null, null, null, null, null);
    app.getContactHelper().createContact(dataContactFilling);
    List<DataContactFilling> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (DataContactFilling d : after) {
      if (d.getId() > max) {
        max = d.getId();
      }
    }
    dataContactFilling.setId(max);
    before.add(dataContactFilling);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
  }
  @Test
  public void testContactCreationWithCollectionLambda() {
    app.goTo().gotoHomePageForContactCreation();
    List<DataContactFilling> before = app.getContactHelper().getContactList();
    DataContactFilling dataContactFilling = new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.getContactHelper().createContact(dataContactFilling);
    List<DataContactFilling> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    dataContactFilling.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(dataContactFilling);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
  }

  @Test
  public void testContactCreationWithCollectionSort() {
    app.goTo().gotoHomePageForContactCreation();
    List<DataContactFilling> before = app.getContactHelper().getContactList();
    DataContactFilling dataContactFilling = new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.getContactHelper().createContact(dataContactFilling);
    List<DataContactFilling> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    dataContactFilling.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(dataContactFilling);
    Comparator<? super DataContactFilling> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
