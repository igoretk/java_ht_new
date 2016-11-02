package ru.stqa.hometask.addressbook.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestModify extends TestBase{

  @Test
  public void testGroupModify() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    if (! applicationManager.getGroupHelper().isThereAnyGroup()) {
      applicationManager.getGroupHelper().createGroup(new DataGroupFilling("t1", "t2", "t3"));
    }
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().editGroup();
    applicationManager.getGroupHelper().fillingTheForm(new DataGroupFilling("hometask1", null, null));
    applicationManager.getGroupHelper().submitEditGroup();
    applicationManager.getGroupHelper().goBackToGroupPage();

  }

}
