package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;
import ru.stqa.hometask.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupTestModifyDb extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new DataGroupFilling().withGroupName("t1").withGroupHeader("t2").withGroupFooter("t3"));
    }
  }

  @Test
  public void testGroupModifyDb() {

    Groups before = app.db().groups();
    DataGroupFilling modifiedGroup = before.iterator().next();
    DataGroupFilling group = new DataGroupFilling().
            withId(modifiedGroup.getId()).withGroupName("test1").withGroupHeader("test2").withGroupFooter("test3");
    app.goTo().GroupPage();
    app.group().modify(group);
    Groups after = app.db().groups();
    assertEquals(before.size(), after.size());
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }

  @Test
  public void testGroupModifyDbAndUi() {

    Groups before = app.db().groups();
    DataGroupFilling modifiedGroup = before.iterator().next();
    DataGroupFilling group = new DataGroupFilling().
            withId(modifiedGroup.getId()).withGroupName("test1").withGroupHeader("test2").withGroupFooter("test3");
    app.goTo().GroupPage();
    app.group().modify(group);
    Groups after = app.db().groups();
    assertEquals(before.size(), after.size());
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();
  }



}


