package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.PhoneInfoData;
import ru.stqa.hometask.addressbook.model.PrimaryInfoData;
import ru.stqa.hometask.addressbook.model.SecondaryInfoData;

public class ContactTestCreation extends TestBase{

  @Test
  public void testContactCreation() throws InterruptedException {

    applicationManager.getContactHelper().initNewContactCreation();
    applicationManager.getContactHelper().primaryInfoFill(new PrimaryInfoData("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field"));
    applicationManager.getContactHelper().phoneInfoFill(new PhoneInfoData("123121", "21321321", "321321321", "32112"));
    applicationManager.getContactHelper().secondaryInfoFill(new SecondaryInfoData("secondary address bla bla bla", "additional info I love cats"));
    applicationManager.getContactHelper().submitNewContactCreation();
  }


}
