package ru.stqa.hometask.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.List;

public class GroupTestDelete extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new DataGroupFilling("t1", "t2", "t3"));
    }
  }

  @Test
  public void testGroupDeleteWithCollection() {
    List<DataGroupFilling> before = app.group().list();
    int indexOfGroup = before.size() - 1;
    app.group().delete(indexOfGroup);
    List<DataGroupFilling> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(indexOfGroup);
    Assert.assertEquals(before, after);

  }


}
