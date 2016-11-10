package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.Comparator;
import java.util.HashSet;
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
    DataGroupFilling group = new DataGroupFilling(before.get(before.size() - 1).getId(), "test1", "test2", "test3");
    applicationManager.getGroupHelper().fillingTheForm(group);
    applicationManager.getGroupHelper().submitEditGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after) );

  }
  @Test
  public void testGroupModifyWithCollectionSortedListsById() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("t1", "t2", "t3"));
    }
    List<DataGroupFilling> before = applicationManager.getGroupHelper().getGroupList();
    applicationManager.getGroupHelper().selectGroup(before.size() - 1);
    applicationManager.getGroupHelper().editGroup();
    DataGroupFilling group = new DataGroupFilling(before.get(before.size() - 1).getId(), "test1", "test2", "test3");
    applicationManager.getGroupHelper().fillingTheForm(group);
    applicationManager.getGroupHelper().submitEditGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super DataGroupFilling> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
