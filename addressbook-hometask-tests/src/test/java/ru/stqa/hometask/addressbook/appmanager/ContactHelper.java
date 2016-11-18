package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.hometask.addressbook.model.Contacts;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitNewContactCreation() {
    click(By.xpath(".//*[@id='content']//input[@value='Enter']"));
  }

  public void fill(DataContactFilling dataContactFilling) {

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
    fill(contact);
    submitNewContactCreation();
    goToHomePage();
  }

  public void modify(int index, DataContactFilling contact) {
    select(index);
    clickToEdit();
    fill(contact);
    submit();
    goToHomePage();
  }

  public void modify(DataContactFilling contact) {
    selectContactById(contact.getId());
    clickToEdit();
    fill(contact);
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

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new DataContactFilling().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

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

  public DataContactFilling infoFromEditForm(DataContactFilling contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    // wd.navigate().back();
    return new DataContactFilling().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath(String.format(".//a[@href='edit.php?id=%s']", id))).click();

  }
}
