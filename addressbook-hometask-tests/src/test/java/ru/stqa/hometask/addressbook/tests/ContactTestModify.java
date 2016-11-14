package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactTestModify extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().ContactPage();
    if (app.contact().list().size() == 0) {
      app.contact().
              create(new DataContactFilling("1", "middle name field", "last name field", "nickName",
                      "title field", "company field", "address field",
                      "123121", "21321321", "321321321", "32112",
                      "secondary address bla bla bla", "additional info I love cats"));
    }
  }

  @Test
  public void testContactModify() {

    int beforeContactCounter = app.contact().getContactCount();
    DataContactFilling contact = new DataContactFilling("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
    app.contact().modify(beforeContactCounter - 1, contact);
    int afterContactCounter = app.contact().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter);

  }

  @Test
  public void testContactModifyWithCollectionSortedLists() {

    int beforeContactCounter = app.contact().getContactCount();
    DataContactFilling contact = new DataContactFilling("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
    app.contact().modify(beforeContactCounter - 1, contact);
    int afterContactCounter = app.contact().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter);

  }

  @Test
  public void testContactModifyWithHashSet() {

    List<DataContactFilling> before = app.contact().list();
    int index = before.size() - 1;
    DataContactFilling contact = new DataContactFilling(before.get(index - 1).getId(), "1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.contact().modify(index, contact);
    List<DataContactFilling> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }



  @Test
  public void testContactModifyWithHashSetWithSort() {

    List<DataContactFilling> before = app.contact().list();
    int index = before.size() - 1;
    DataContactFilling contact = new DataContactFilling(before.get(before.size() - 1).getId(), "1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.contact().modify(index, contact);
    List<DataContactFilling> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    Comparator<? super DataContactFilling> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
