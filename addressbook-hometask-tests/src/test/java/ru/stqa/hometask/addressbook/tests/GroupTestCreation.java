package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.HashSet;
import java.util.List;

public class GroupTestCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    int beforeGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    applicationManager.getGroupHelper().createGroup(new DataGroupFilling("1", "2", "3"));
    int afterGroupCounter = applicationManager.getGroupHelper().getGroupCount();
    Assert.assertEquals(afterGroupCounter, beforeGroupCounter + 1);

  }

  @Test
  public void testGroupCreationWithCollection() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    List<DataGroupFilling> before = applicationManager.getGroupHelper().getGroupList();
    DataGroupFilling group = new DataGroupFilling("1", "2", "3");
    applicationManager.getGroupHelper().createGroup(group);
    List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (DataGroupFilling d : after) {
      if (d.getId() > max) {
        max = d.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}
