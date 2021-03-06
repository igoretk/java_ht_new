package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.Contacts;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactTestDelete extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().ContactPage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName"));
        }
    }

    /*
  @Test
  public void testContactDelete() {

    int beforeContactCounter = app.contact().getContactCount();
    int index = 0;
    app.contact().delete(index);
    int afterContactCounter = app.contact().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter - 1);
  }

  @Test
  public void testContactDeleteWithCollections() {

    List<DataContactFilling> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<DataContactFilling> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index - 1);
    Assert.assertEquals(before, after);
  }
}
*/
    @Test
    public void testContactDeleteWithCollectionsWithFluent() {

        List<DataContactFilling> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<DataContactFilling> after = app.contact().list();
        assertEquals(after.size(), before.size() - 1);

        before.remove(index );
        assertEquals(before, after);
    }
    @Test
    public void testContactDeleteWithUniqueId() {

        Set<DataContactFilling> before = app.contact().all();
        DataContactFilling deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<DataContactFilling> after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        assertEquals(before, after);
    }
    @Test
    public void testContactDeleteWithUniqueIdAndHam() {

        Contacts before = app.contact().all();
        DataContactFilling deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.withOut(deletedContact)));
    }
}

