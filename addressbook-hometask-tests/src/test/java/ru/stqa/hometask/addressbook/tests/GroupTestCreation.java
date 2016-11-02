package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupTestCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    applicationManager.getNavigationHelper().gotoGroupsPage();
    applicationManager.getGroupHelper().createGroup(new DataGroupFilling("1", "2", "3"));

  }

}
