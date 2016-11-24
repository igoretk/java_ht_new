package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.Contacts;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactTestModify extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().ContactPage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName"));
        }
    }
/*
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

*/

    @Test
    public void testContactModifyWithFluent() {

        List<DataContactFilling> before = app.contact().list();
        int index = before.size() - 1;
        DataContactFilling contact = new DataContactFilling()
                .withId(before.get(before.size() - 1).getId()).withFirstName("FirstName").withLastName("LastName");
        app.contact().modify(index, contact);
        List<DataContactFilling> after = app.contact().list();
        assertEquals(after.size(), before.size());

        Comparator<? super DataContactFilling> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        assertEquals(before, after);
    }
    @Test
    public void testContactModifyWithUniqueId() {

        Set<DataContactFilling> before = app.contact().all();
        DataContactFilling modifiedContact = before.iterator().next();
        DataContactFilling contact = new DataContactFilling()
                .withId(modifiedContact.getId()).withFirstName("FirstName").withLastName("LastName");
        app.contact().modify(contact);
        Set<DataContactFilling> after = app.contact().all();
        assertEquals(after.size(), before.size());

        assertEquals(before, after);
    }
    @Test
    public void testContactModifyWithUniqueIdAndHam() {

        Contacts before = app.contact().all();
        DataContactFilling modifiedContact = before.iterator().next();
        DataContactFilling contact = new DataContactFilling()
                .withId(modifiedContact.getId()).withFirstName("FirstName").withLastName("LastName");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }
}
