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
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("test1", "test2", "test3"));
    }
    List<DataGroupFilling> before = applicationManager.getGroupHelper().getGroupList();
    applicationManager.getGroupHelper().selectGroup(0);
    applicationManager.getGroupHelper().deleteGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();
    List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1); // делаем старый и новый списки одинаковыми и сравниваем поэлементно
   /* for (int i = 0; i < after.size(); i++) {
      Assert.assertEquals(before.get(i), after.get(i)); // можно делать без цикла, т.к среда разработки сама умеет сравнивать списки
    }
    */
    Assert.assertEquals(before, after);

  }
}
