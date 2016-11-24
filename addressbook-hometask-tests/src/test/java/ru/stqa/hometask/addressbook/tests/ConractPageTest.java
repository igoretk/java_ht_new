package ru.stqa.hometask.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConractPageTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().ContactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withAddress("leninskaya ave 52/31")
              .withEmail1("email1@google.com").withEmail2("email2@mail.ru").withEmail3("email3@yandex.ru"));
    }
  }
  @Test
  public void testContactPage() {
    app.goTo().ContactPage();
    DataContactFilling contact = app.contact().allReverseCheck().iterator().next();
    DataContactFilling contactInfoFromDetails = app.contact().infoFromDetails(contact);
    assertThat(contact.getFirstName(), equalTo(contactInfoFromDetails.getFirstName()));
  }

}
