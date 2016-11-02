package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestDelete extends TestBase {
  @Test
  public void testGroupDelete() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("1", "2", "3"));
    }
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
  }
}
