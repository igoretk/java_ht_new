package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.hometask.addressbook.model.Contacts;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitNewContactCreation() {
    click(By.xpath(".//*[@id='content']//input[@value='Enter']"));
  }

  public void fill(DataContactFilling dataContactFilling, boolean creation) {

    type(By.name("firstname"), dataContactFilling.getFirstName()); //primary info filling
    type(By.name("lastname"), dataContactFilling.getLastName());
    type(By.name("address"), dataContactFilling.getAddress());
    type(By.name("home"), dataContactFilling.getHomePhone()); // phone info filling
    type(By.name("mobile"), dataContactFilling.getMobilePhone());
    type(By.name("work"), dataContactFilling.getWorkPhone());
    type(By.name("email"), dataContactFilling.getEmail1());
    type(By.name("email2"), dataContactFilling.getEmail2());
    type(By.name("email3"), dataContactFilling.getEmail3());
  }
  //attach(By.name("photo"), dataContactFilling.getPhoto());

   /* if (creation) {
      if (dataContactFilling.getGroups().size() > 0) {
        assertTrue(dataContactFilling.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(dataContactFilling.getGroups().iterator().next().getGroupName());
      }
      else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }

  }*/

  public void initNewContactCreation() {
    click(By.linkText("add new"));
  }

  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void clickToEdit() {
    click(By.xpath(".//*[@id='maintable']//*[@alt ='Edit']"));
  }

  public void submit() {
    click(By.name("update"));
  }

  public void deleteContact() {
    click(By.xpath(".//*[@id='content']//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void create(DataContactFilling contact) {
    initNewContactCreation();
    fill(contact, true);
    submitNewContactCreation();
    goToHomePage();
  }

  public void modify(int index, DataContactFilling contact) {
    select(index);
    clickToEdit();
    fill(contact, true);
    submit();
    goToHomePage();
  }

  public void modify(DataContactFilling contact) {
    selectContactById(contact.getId());
    clickToEdit();
    fill(contact, true);
    submit();
    goToHomePage();
  }

  public void delete(int index) {
    select(index);
    deleteContact();
    goToHomePage();
  }

  public void delete(DataContactFilling contact) {
    selectContactById(contact.getId());
    deleteContact();
    goToHomePage();
  }

  public void goToHomePage() {
    click(By.id("logo"));
  }

  public boolean isAnyContactThere() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<DataContactFilling> list() {
    List<DataContactFilling> contacts = new ArrayList<DataContactFilling>();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

  /*public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }*/

  public Set<DataContactFilling> allForPhones() {
    Set<DataContactFilling> contacts = new HashSet<>();
    List<WebElement> rows = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contacts.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
    }
    return contacts;
  }

  public Set<DataContactFilling> allForAddressForReverseCheck() {
    Set<DataContactFilling> addresses = new HashSet<>();
    List<WebElement> rows = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allAddress = cells.get(3).getText();
      addresses.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAddress(allAddress));
    }
    return addresses;
  }

  public Set<DataContactFilling> allReverseCheck() {
    Set<DataContactFilling> contacts = new HashSet<>();
    List<WebElement> rows = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allAddress = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      contacts.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAddress(allAddress)
              .withAllPhones(allPhones)
              .withAllEmails(allEmails));
    }
    return contacts;
  }

  public DataContactFilling infoFromEditForm(DataContactFilling contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new DataContactFilling().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withAddress(address)
            .withEmail1(email1).withEmail2(email2).withEmail3(email3);
  }

  public DataContactFilling infoFromDetails(DataContactFilling contact) {
    initContactDetailedById(contact.getId());

    String info[] = wd.findElement(By.id("content")).getText().replaceAll("[-():]", "").replaceAll("[MWH]", "")
            .replaceAll("\\n+\\s*", "\n").replaceFirst(" ", "\n").split("\n");

//    String email1 = wd.findElement(By.cssSelector("a[href='mailto:email']")).getText();
//    String email2 = wd.findElement(By.cssSelector("a[href='mailto:email2']")).getText();
    //   String email3 = wd.findElement(By.cssSelector("a[href='mailto:email3']")).getText();
    wd.navigate().back();

    return new DataContactFilling().withId(contact.getId()).withFirstName(info[0]).withLastName(info[1])
            .withHomePhone(info[2]).withMobilePhone(info[3]).withWorkPhone(info[4])
            .withAddress(info[5])
            ;
  }

  public void initContactDetailedById(int id) {
    wd.findElement(By.xpath(String.format(".//a[@href='view.php?id=%s']", id))).click();

  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath(String.format(".//a[@href='edit.php?id=%s']", id))).click();

  }

  private Contacts contactCache = null;

  public Contacts all() {

    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      contactCache.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName).
              withAddress(address).withAllPhones(allPhones).
              withAllEmails(allEmails));
      String[] phones = element.findElement(By.xpath(".//td[6]")).getText().split("\n");
      contactCache.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName).withAddress("Address").
              withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]).
              withEmail1("email").withEmail2("email2").withEmail3("email3"));
    }
    return contactCache;
  }

  public int count() {

    return wd.findElements(By.name("selected[]")).size();
  }

}
