package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends  HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void goBackToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitNewGroupCreation() {
    click(By.name("submit"));
  }

  public void initNewGroupCreation() {
    click(By.name("new"));
  }

  public void fillingTheForm(DataGroupFilling dataGroupFilling) {
    type(By.name("group_name"), dataGroupFilling.getGroupName());
    type(By.name("group_header"), dataGroupFilling.getGroupHeader());
    type(By.name("group_footer"), dataGroupFilling.getGroupFooter());
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void editGroup() {
    click(By.name("edit"));
  }

  public void submitEditGroup() {
    click(By.name("update"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }

  public void create(DataGroupFilling group) {
    initNewGroupCreation();
    fillingTheForm(group);
    submitNewGroupCreation();
    goBackToGroupPage();
  }
  public void modify(DataGroupFilling group) {
    selectGroupById(group.getId());
    editGroup();
    fillingTheForm(group);
    submitEditGroup();
    goBackToGroupPage();
  }
  /*public void modify(int indexOfGroup, DataGroupFilling group) {
    selectGroupById(indexOfGroup);
    editGroup();
    fillingTheForm(group);
    submitEditGroup();
    goBackToGroupPage();
  }*/

  public void delete(int indexOfGroup) {
    selectGroup(indexOfGroup);
    deleteGroup();
    goBackToGroupPage();
  }
  public void delete(DataGroupFilling group) {
    selectGroupById(group.getId());
    deleteGroup();
    goBackToGroupPage();
  }

  public boolean isThereAnyGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<DataGroupFilling> list() {
    List<DataGroupFilling> groups = new ArrayList<DataGroupFilling>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      DataGroupFilling group = new DataGroupFilling().withId(id).withGroupName(name);
      groups.add(group);
    }
    return groups;
  }
  public Set<DataGroupFilling> all() {
    Set<DataGroupFilling> groups = new HashSet<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      DataGroupFilling group = new DataGroupFilling().withId(id).withGroupName(name);
      groups.add(group);
    }
    return groups;
  }


}
