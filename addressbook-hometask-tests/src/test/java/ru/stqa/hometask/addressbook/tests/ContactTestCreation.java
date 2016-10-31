package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.PhoneInfoData;
import ru.stqa.hometask.addressbook.model.PrimaryInfoData;
import ru.stqa.hometask.addressbook.model.SecondaryInfoData;

public class ContactTestCreation extends TestBase{

  @Test
  public void testContactCreation() throws InterruptedException {

    applicationManager.initNewContactCreation();
    applicationManager.primaryInfoFill(new PrimaryInfoData("firsname field", "middle name field", "last name field", "nickName", "title field", "company field", "address field"));
    applicationManager.phoneInfoFill(new PhoneInfoData("123121", "21321321", "321321321", "32112"));
    applicationManager.secondaryInfoFill(new SecondaryInfoData("secondary address bla bla bla", "additional info I love cats"));
    applicationManager.submitNewContactCreation();
  }


}
