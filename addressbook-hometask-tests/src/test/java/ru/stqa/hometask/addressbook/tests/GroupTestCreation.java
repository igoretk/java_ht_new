package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;
import ru.stqa.hometask.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    public void testGroupCreationWithUniqueIdAndHam() {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        DataGroupFilling group = new DataGroupFilling().withGroupName("1").withGroupHeader("2").withGroupFooter("3");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}
