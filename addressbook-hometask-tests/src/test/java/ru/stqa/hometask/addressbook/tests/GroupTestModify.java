package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.List;

public class GroupTestModify extends TestBase{

  @Test
  public void testGroupModify() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("t1", "t2", "t3"));
    }
    int beforeGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    applicationManager.getGroupHelper().selectGroup(beforeGroupCounter - 1);
    applicationManager.getGroupHelper().editGroup();
    applicationManager.getGroupHelper().fillingTheForm(new DataGroupFilling("hometask1", null, null));
    applicationManager.getGroupHelper().submitEditGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    int afterGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    Assert.assertEquals(beforeGroupCounter, afterGroupCounter);

  }
  @Test
  public void testGroupModifyWithCollection() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("t1", "t2", "t3"));
    }
    List<DataGroupFilling> before = applicationManager.getGroupHelper().getGroupList();
    applicationManager.getGroupHelper().selectGroup(before.size() - 1);
    applicationManager.getGroupHelper().editGroup();
    applicationManager.getGroupHelper().fillingTheForm(new DataGroupFilling("hometask1", null, null));
    applicationManager.getGroupHelper().submitEditGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());

  }

}
