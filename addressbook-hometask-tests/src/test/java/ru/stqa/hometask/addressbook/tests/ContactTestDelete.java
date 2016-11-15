package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.List;

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
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index );
        Assert.assertEquals(before, after);
    }
}

