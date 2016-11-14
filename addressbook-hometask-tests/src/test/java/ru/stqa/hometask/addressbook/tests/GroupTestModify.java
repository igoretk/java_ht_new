package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupTestModify extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new DataGroupFilling().withGroupName("t1").withGroupHeader("t2").withGroupFooter("t3"));
        }
    }

    /*@Test
    public void testGroupModify() {

        int beforeGroupCounter = app.group().getGroupCount();
        app.group().modify(beforeGroupCounter - 1, new DataGroupFilling().withGroupName("t1"));
        int afterGroupCounter = app.group().getGroupCount();
        Assert.assertEquals(beforeGroupCounter, afterGroupCounter);

    }

    @Test
    public void testGroupModifyWithCollection() {

        List<DataGroupFilling> before = app.group().list();
        int indexOfGroup = before.size() - 1;
        DataGroupFilling group = new DataGroupFilling().
                withId(before.get(indexOfGroup).getId()).withGroupName("test1").withGroupHeader("test2").withGroupFooter("test3");
        app.group().modify(indexOfGroup, group);
        List<DataGroupFilling> after = app.group().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(indexOfGroup);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }

    @Test
    public void testGroupModifyWithCollectionSortedListsById() {

        List<DataGroupFilling> before = app.group().list();
        int indexOfGroup = before.size() - 1;
        DataGroupFilling group = new DataGroupFilling().
                withId(before.get(indexOfGroup).getId()).withGroupName("test1").withGroupHeader("test2").withGroupFooter("test3");
        app.group().modify(indexOfGroup, group);
        List<DataGroupFilling> after = app.group().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(indexOfGroup);
        before.add(group);
        Comparator<? super DataGroupFilling> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    } */
    @Test
    public void testGroupModifyWithUniqueId() {

        Set<DataGroupFilling> before = app.group().all();
        DataGroupFilling modifiedGroup = before.iterator().next();
        DataGroupFilling group = new DataGroupFilling().
                withId(modifiedGroup.getId()).withGroupName("test1").withGroupHeader("test2").withGroupFooter("test3");
        app.group().modify(group);
        Set<DataGroupFilling> after = app.group().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
