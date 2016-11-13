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
        applicationManager.getNavigationHelper().gotoGroupsPage();
        if (!applicationManager.getGroupHelper().isThereAnyGroup()) {
            applicationManager.getGroupHelper().createGroup(new DataGroupFilling("t1", "t2", "t3"));
        }
    }

    @Test
    public void testGroupModify() {

        int beforeGroupCounter = applicationManager.getGroupHelper().getGroupCount();
        applicationManager.getGroupHelper().modifyGroup(beforeGroupCounter - 1, new DataGroupFilling("hometask1", null, null));
        int afterGroupCounter = applicationManager.getGroupHelper().getGroupCount();
        Assert.assertEquals(beforeGroupCounter, afterGroupCounter);

    }

    @Test
    public void testGroupModifyWithCollection() {

        List<DataGroupFilling> before = applicationManager.getGroupHelper().getGroupList();
        int indexOfGroup = before.size() - 1;
        DataGroupFilling group = new DataGroupFilling(before.get(indexOfGroup).getId(), "test1", "test2", "test3");
        applicationManager.getGroupHelper().modifyGroup(indexOfGroup, group);
        List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(indexOfGroup);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }

    @Test
    public void testGroupModifyWithCollectionSortedListsById() {

        List<DataGroupFilling> before = applicationManager.getGroupHelper().getGroupList();
        int indexOfGroup = before.size() - 1;
        DataGroupFilling group = new DataGroupFilling(before.get(indexOfGroup).getId(), "test1", "test2", "test3");
        applicationManager.getGroupHelper().modifyGroup(indexOfGroup, group);
        List<DataGroupFilling> after = applicationManager.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(indexOfGroup);
        before.add(group);
        Comparator<? super DataGroupFilling> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
