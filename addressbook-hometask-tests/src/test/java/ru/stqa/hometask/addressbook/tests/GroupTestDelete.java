package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;
import ru.stqa.hometask.addressbook.model.Groups;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupTestDelete extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new DataGroupFilling().withGroupName("t1").withGroupHeader("t2").withGroupFooter("t3"));
    }
  }

  @Test
  public void testGroupDeleteWithCollection() {
    List<DataGroupFilling> before = app.group().list();
    int indexOfGroup = before.size() - 1;
    app.group().delete(indexOfGroup);
    List<DataGroupFilling> after = app.group().list();
    assertEquals(after.size(), before.size() - 1);

    before.remove(indexOfGroup);
    assertEquals(before, after);

  }
  @Test
  public void testGroupDeleteWithUniqueIdAndHam() {
    Groups before = app.group().all();
    DataGroupFilling deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.withOut(deletedGroup)));

  }

}
