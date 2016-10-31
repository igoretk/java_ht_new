package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification() {
    applicationManager.getNavigationHelper().gotoGroupPage();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().initGroupModification();
    applicationManager.getGroupHelper().fillGroupForm(new GroupData("sfsef", "sefsef", "sef"));
    applicationManager.getGroupHelper().submitGroupModification();
    applicationManager.getGroupHelper().returnToGroupPage();
  }
}
