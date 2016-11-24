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

public class ContactAddressTests extends TestBase {
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
  public void testContactPhoneAddressEmailReverseCheck() {
    app.goTo().ContactPage();
    DataContactFilling contact = app.contact().allReverseCheck().iterator().next();
    DataContactFilling contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergeEmails(DataContactFilling contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(DataContactFilling contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("[-()\\s]", "");
  }

}


