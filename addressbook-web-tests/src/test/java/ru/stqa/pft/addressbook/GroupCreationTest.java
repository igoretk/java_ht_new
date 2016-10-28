package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    applicationManager.gotoGroupPage();
    applicationManager.initGroupCreation();
    applicationManager.fillGroupForm(new GroupData("test1", "test2", "test3"));
    applicationManager.submitGroupCreation();
    applicationManager.returnToGroupPage();
  }

}
