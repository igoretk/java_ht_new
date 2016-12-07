package ru.stqa.hometask.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConractPageTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().ContactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withAddress("leninskaya ave 52/31"));
    }
  }
  @Test
  public void testContactPage() {
    app.goTo().ContactPage();
    DataContactFilling contact = app.contact().allForAddressForReverseCheck().iterator().next();
    DataContactFilling contactInfoFromEdit = app.contact().infoFromEditForm(contact);
    app.goTo().ContactPage();
    DataContactFilling contactInfoFromDetails = app.contact().infoFromDetails(contact);
    assertThat(contactInfoFromEdit, equalTo(contactInfoFromDetails));
  }



}
