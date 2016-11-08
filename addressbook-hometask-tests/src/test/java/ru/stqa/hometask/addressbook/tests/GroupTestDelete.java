package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.List;

public class GroupTestDelete extends TestBase {
  @Test
  public void testGroupDelete() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("1", "2", "3"));
    }
    int beforeGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    applicationManager.getGroupHelper().selectGroup(0);
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    int afterGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    Assert.assertEquals(afterGroupCounter, beforeGroupCounter - 1);

  }
  @Test
  public void testGroupDeleteWithCollection() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("1", "2", "3"));
    }
    List<DataGroupFilling> before = applicationManager.getGroupHelper().getGroupList();
    applicationManager.getGroupHelper().selectGroup(0);
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

  }
}
