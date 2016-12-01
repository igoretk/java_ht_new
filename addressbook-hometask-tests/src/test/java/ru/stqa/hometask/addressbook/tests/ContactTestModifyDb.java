package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.Contacts;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactTestModifyDb extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().ContactPage();
      app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName"));
    }
  }

  @Test
  public void testContactModifyDb() {

    Contacts before = app.db().contacts();
    DataContactFilling modifiedContact = before.iterator().next();
    DataContactFilling contact = new DataContactFilling()
            .withId(modifiedContact.getId()).withFirstName("FirstName").withLastName("LastName");
    app.goTo().ContactPage();
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }
}
