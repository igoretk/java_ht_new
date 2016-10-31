package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

public class GroupHelper {
  private WebDriver wd;

  public GroupHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void goBackToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitNewGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void initNewGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void fillingTheForm(DataGroupFilling dataGroupFilling) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(dataGroupFilling.getGroupName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(dataGroupFilling.getGroupHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(
            dataGroupFilling.getGroupFooter());
  }
}
