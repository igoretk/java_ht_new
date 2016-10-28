package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    applicationManager.gotoGroupPage();
    applicationManager.selectGroup();
    applicationManager.deleteSeclectGroup();
    applicationManager.gotoGroupPage();
  }

}
