package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupTestModify extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new DataGroupFilling("t1", "t2", "t3"));
        }
    }

    @Test
    public void testGroupModify() {

        int beforeGroupCounter = app.group().getGroupCount();
        app.group().modify(beforeGroupCounter - 1, new DataGroupFilling("hometask1", null, null));
        int afterGroupCounter = app.group().getGroupCount();
        Assert.assertEquals(beforeGroupCounter, afterGroupCounter);

    }

    @Test
    public void testGroupModifyWithCollection() {

        List<DataGroupFilling> before = app.group().list();
        int indexOfGroup = before.size() - 1;
        DataGroupFilling group = new DataGroupFilling(before.get(indexOfGroup).getId(), "test1", "test2", "test3");
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
        DataGroupFilling group = new DataGroupFilling(before.get(indexOfGroup).getId(), "test1", "test2", "test3");
        app.group().modify(indexOfGroup, group);
        List<DataGroupFilling> after = app.group().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(indexOfGroup);
        before.add(group);
        Comparator<? super DataGroupFilling> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
