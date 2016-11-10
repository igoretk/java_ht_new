package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.List;


public class ContactTestCreation extends TestBase{

  @Test
  public void testContactCreation() throws InterruptedException {

    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    int beforeContactCounter = applicationManager.getContactHelper().getContactCount();
    applicationManager.getContactHelper().
            createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                    "123121", "21321321", "321321321", "32112",
                    "secondary address bla bla bla", "additional info I love cats"));
   int afterContactCounter = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter + 1);

  }
  @Test
  public void testContactCreationWithCollection() {

    applicationManager.getNavigationHelper().gotoHomePageForContactCreation();
    List<DataContactFilling> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getContactHelper().
            createContact(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field",
                    "123121", "21321321", "321321321", "32112",
                    "secondary address bla bla bla", "additional info I love cats"));
    List<DataContactFilling> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

  }


}
