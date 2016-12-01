package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.Contacts;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactTestDeleteDb extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().ContactPage();
      app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName"));
    }
  }
  @Test
  public void testContactDeleteDb() {

    Contacts before = app.db().contacts();
    DataContactFilling deletedContact = before.iterator().next();
    app.goTo().ContactPage();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.withOut(deletedContact)));
  }
}
