package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.hometask.addressbook.model.PhoneInfoData;
import ru.stqa.hometask.addressbook.model.PrimaryInfoData;
import ru.stqa.hometask.addressbook.model.SecondaryInfoData;

public class ContactHelper {
  private WebDriver wd;

  public ContactHelper(WebDriver wd) {

    this.wd = wd;
  }

  public void submitNewContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void secondaryInfoFill(SecondaryInfoData secondaryInfoData) {
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(secondaryInfoData.getSecondaryAddress());
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(secondaryInfoData.getNotes());
  }

  public void phoneInfoFill(PhoneInfoData phoneInfoData) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(phoneInfoData.getHomePhone());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(phoneInfoData.getMobilePhone());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(phoneInfoData.getWorkPhone());
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(phoneInfoData.getFax());
  }

  public void primaryInfoFill(PrimaryInfoData primaryInfoData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(primaryInfoData.getFirstName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(primaryInfoData.getMiddleName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(primaryInfoData.getLastName());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(primaryInfoData.getNickName());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(primaryInfoData.getTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(primaryInfoData.getCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(primaryInfoData.getAddress());
  }

  public void initNewContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }
}
