package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupTestCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    int beforeGroupCounter = app.group().getGroupCount();
    app.group().create(new DataGroupFilling().withGroupName("1").withGroupHeader("2").withGroupFooter("3"));
    int afterGroupCounter = app.group().getGroupCount();
    Assert.assertEquals(afterGroupCounter, beforeGroupCounter + 1);

  }

  @Test
  public void testGroupCreationWithCollection() {
    app.goTo().GroupPage();
    List<DataGroupFilling> before = app.group().list();
    DataGroupFilling group = new DataGroupFilling().withGroupName("1").withGroupHeader("2").withGroupFooter("3");
    app.group().create(group);
    List<DataGroupFilling> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
  @Test
  public void testGroupCreationWithUniqueId() {
    app.goTo().GroupPage();
    Set<DataGroupFilling> before = app.group().all();
    DataGroupFilling group = new DataGroupFilling().withGroupName("1").withGroupHeader("2").withGroupFooter("3");
    app.group().create(group);
    Set<DataGroupFilling> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before,after);

  }

}
