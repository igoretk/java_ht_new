package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

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

}