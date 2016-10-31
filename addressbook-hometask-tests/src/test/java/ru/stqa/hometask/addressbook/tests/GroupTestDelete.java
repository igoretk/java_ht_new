package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;

public class GroupTestDelete extends TestBase {
  @Test
  public void testGroupDelete() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
  }
}
