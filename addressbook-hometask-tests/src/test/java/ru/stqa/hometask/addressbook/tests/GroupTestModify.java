package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestModify extends TestBase{

  @Test
  public void testGroupModify() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().editGroup();
    applicationManager.getGroupHelper().fillingTheForm(new DataGroupFilling("hometask1", null, null));
    applicationManager.getGroupHelper().submitEditGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();

  }

}
