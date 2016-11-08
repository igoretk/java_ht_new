package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestDelete extends TestBase {
  @Test
  public void testGroupDelete() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    int beforeGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("1", "2", "3"));
    }
    applicationManager.getGroupHelper().selectGroup(0);
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    int afterGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    Assert.assertEquals(afterGroupCounter, beforeGroupCounter - 1);

  }
}
