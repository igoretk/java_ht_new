package ru.stqa.hometask.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().ContactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new DataContactFilling().withFirstName("FirstName").withLastName("LastName")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333"));
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().ContactPage();
    DataContactFilling contact = app.contact().allForPhones().iterator().next();
    DataContactFilling contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));

  }
  public String cleaned(String phone) {
    return phone.replaceAll("[-()\\s]", "");
  }
}
