package ru.stqa.hometask.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.BeforeMethod;
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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTestCreationDb extends TestBase {
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
  public void testContactCreationDb(DataContactFilling contact) {
    app.goTo().ContactPage();
    Contacts before = app.db().contacts();
    app.contact().create(contact);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0 || app.group().list().size() == 0) {
      app.goTo().ContactPage();
      app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName"));
      app.goTo().GroupPage();
      app.group().create(new DataGroupFilling().withGroupName("t1").withGroupHeader("t2").withGroupFooter("t3"));
    }
  }

  @Test
  public void testContactAdd() {
    Groups groups = app.db().groups();
    DataContactFilling newContact = new DataContactFilling().withFirstName("test_name").withLastName("test_surname")
            .inGroup(groups.iterator().next());
    Groups before = app.db().groups();
    app.goTo().ContactPage();
    app.contact().initNewContactCreation();
    app.contact().fill(newContact, true);
    app.contact().submitNewContactCreation();
    app.contact().goToHomePage();
    Groups after = app.db().groups();
    assertThat(after, equalTo(before));

  }
}
