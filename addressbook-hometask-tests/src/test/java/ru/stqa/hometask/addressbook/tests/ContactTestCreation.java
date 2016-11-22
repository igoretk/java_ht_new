package ru.stqa.hometask.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.Contacts;
import ru.stqa.hometask.addressbook.model.DataContactFilling;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;
import ru.stqa.hometask.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactTestCreation extends TestBase {
  /*
  @Test
  public void testContactCreation() throws InterruptedException {
    app.goTo().ContactPage();
    int beforeContactCounter = app.contact().getContactCount();
    app.contact().create(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName",
            "title field", "company field", "address field",
            "123121", "21321321", "321321321", "32112",
            "secondary address bla bla bla", "additional info I love cats"));
    int afterContactCounter = app.contact().getContactCount();
    Assert.assertEquals(afterContactCounter, beforeContactCounter + 1);

  }

  @Test
  public void testContactCreationWithCollection() {
    app.goTo().ContactPage();
    List<DataContactFilling> before = app.contact().list();
    app.contact().create(new DataContactFilling("firsname field", "middle name field", "last name field", "nickName",
            "title field", "company field", "address field",
            "123121", "21321321", "321321321", "32112",
            "secondary address bla bla bla", "additional info I love cats"));
    List<DataContactFilling> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

  }

  @Test
  public void testContactCreationWithCollectionSearchMax() {
    app.goTo().ContactPage();
    List<DataContactFilling> before = app.contact().list();
    DataContactFilling dataContactFilling = new DataContactFilling("1", "2", "3", null, null, null, null, null, null, null, null, null, null);
    app.contact().create(dataContactFilling);
    List<DataContactFilling> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (DataContactFilling d : after) {
      if (d.getId() > max) {
        max = d.getId();
      }
    }
    dataContactFilling.setId(max);
    before.add(dataContactFilling);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
  }

  @Test
  public void testContactCreationWithCollectionLambda() {
    app.goTo().ContactPage();
    List<DataContactFilling> before = app.contact().list();
    DataContactFilling dataContactFilling = new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.contact().create(dataContactFilling);
    List<DataContactFilling> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    dataContactFilling.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(dataContactFilling);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
  }


  @Test
  public void testContactCreationWithCollectionSort() {
    app.goTo().ContactPage();
    List<DataContactFilling> before = app.contact().list();
    DataContactFilling dataContactFilling = new DataContactFilling("1", "2", "3", "4", null, null, null, null, null, null, null, null, null);
    app.contact().create(dataContactFilling);
    List<DataContactFilling> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    dataContactFilling.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(dataContactFilling);
    Comparator<? super DataContactFilling> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
  */
  @Test
  public void testContactCreationWithFluent() {
    app.goTo().ContactPage();
    List<DataContactFilling> before = app.contact().list();
    DataContactFilling dataContactFilling = new DataContactFilling().withFirstName("FirstName").withLastName("LastName");
    app.contact().create(dataContactFilling);
    List<DataContactFilling> after = app.contact().list();
    assertEquals(after.size(), before.size() + 1);

    dataContactFilling.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(dataContactFilling);
    Comparator<? super DataContactFilling> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    assertEquals(before, after);
  }

  @Test
  public void testContactCreationWithUniqueId() {
    app.goTo().ContactPage();
    Set<DataContactFilling> before = app.contact().all();
    DataContactFilling dataContactFilling = new DataContactFilling().withFirstName("FirstName").withLastName("LastName");
    app.contact().create(dataContactFilling);
    Set<DataContactFilling> after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);

    dataContactFilling.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(dataContactFilling);
    assertEquals(before, after);
  }

  @Test
  public void testContactCreationWithUniqueIdAndHam() {
    app.goTo().ContactPage();
    Contacts before = app.contact().all();
    DataContactFilling dataContactFilling = new DataContactFilling().withFirstName("FirstName").withLastName("LastName");
    app.contact().create(dataContactFilling);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(dataContactFilling.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testContactCreationFiles() {
    app.goTo().ContactPage();
    app.contact().initNewContactCreation();
    File photo = new File("src/test/resources/photo.jpg");
    app.contact().fill(new DataContactFilling().withFirstName("test_name").withLastName("test_surname").withPhoto(photo));
    app.contact().submitNewContactCreation();
    app.contact().goToHomePage();
  }

  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/photo.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }

  @DataProvider
  public Iterator<Object[]> validContactsFromFileJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<DataContactFilling> contacts = gson.fromJson(json, new TypeToken<List<DataContactFilling>>(){}.getType()); // List<DataContactFilling>.class
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromFileJson")
  public void testContactCreationWithFromFileJson(DataContactFilling contact) {
    app.goTo().ContactPage();
    Contacts before = app.contact().all();
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
