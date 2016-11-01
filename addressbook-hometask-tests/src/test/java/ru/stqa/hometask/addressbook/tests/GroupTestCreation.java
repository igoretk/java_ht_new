package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    applicationManager.getGroupHelper().initNewGroupCreation();
    applicationManager.getGroupHelper().fillingTheForm(new DataGroupFilling("hometask1", null, null));
    applicationManager.getGroupHelper().submitNewGroupCreation();
    applicationManager.getGroupHelper().goBackToGroupPage();
  }

}
