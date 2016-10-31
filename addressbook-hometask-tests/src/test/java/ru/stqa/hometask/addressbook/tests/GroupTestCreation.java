package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupsPage();
    initNewGroupCreation();
    fillingTheForm(new DataGroupFilling("hometask1", "hometaskheader", "hometaskfooter"));
    submitNewGroupCreation();
    goBackToGroupPage();
  }

}
