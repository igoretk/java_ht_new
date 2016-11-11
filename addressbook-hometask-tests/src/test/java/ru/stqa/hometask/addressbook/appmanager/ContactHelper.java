package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitNewContactCreation() {
    click(By.xpath(".//*[@id='content']//input[@value='Enter']"));
  }

  public void fillingTheForms(DataContactFilling dataContactFilling) {

    type(By.name("firstname"), dataContactFilling.getFirstName()); //primary info filling
    type(By.name("middlename"), dataContactFilling.getMiddleName());
    type(By.name("lastname"), dataContactFilling.getLastName());
    type(By.name("nickname"), dataContactFilling.getNickName());
    type(By.name("title"), dataContactFilling.getTitle());
    type(By.name("company"), dataContactFilling.getCompany());
    type(By.name("address"), dataContactFilling.getAddress());

    type(By.name("home"), dataContactFilling.getHomePhone()); // phone info filling
    type(By.name("mobile"), dataContactFilling.getMobilePhone());
    type(By.name("work"), dataContactFilling.getWorkPhone());
    type(By.name("fax"), dataContactFilling.getFax());

    type(By.name("address2"), dataContactFilling.getSecondaryAddress()); // secondary info filling
    type(By.name("notes"), dataContactFilling.getNotes());


  }

  public void initNewContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectToEditContactPrimaryInfo() {
    click(By.xpath(".//*[@id='maintable']//*[@alt ='Edit']"));
  }

  public void submitEditContact() {
    click(By.name("update"));
  }

  public void deleteContact() {
    click(By.xpath(".//*[@id='content']//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void createContact(DataContactFilling contact) {
    initNewContactCreation();
    fillingTheForms(contact);
    submitNewContactCreation();
    getBackHomePage();

  }

  public void getBackHomePage() {
    click(By.id("logo"));
  }

  public boolean isAnyContactThere() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<DataContactFilling> getContactList() {
    List<DataContactFilling> contacts = new ArrayList<DataContactFilling>();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));

    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      DataContactFilling contact = new DataContactFilling(id, name, null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
