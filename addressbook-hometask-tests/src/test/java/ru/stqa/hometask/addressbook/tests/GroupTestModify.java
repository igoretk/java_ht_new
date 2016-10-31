package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestModify extends TestBase{

  @Test
  public void testGroupModify() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().editGroup();
    applicationManager.getGroupHelper().fillingTheForm(new DataGroupFilling("1", "2", "3"));
    applicationManager.getGroupHelper().submitEditGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();

  }

}
