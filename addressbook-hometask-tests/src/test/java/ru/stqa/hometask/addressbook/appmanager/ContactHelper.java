package ru.stqa.hometask.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.hometask.addressbook.model.PhoneInfoData;
import ru.stqa.hometask.addressbook.model.PrimaryInfoData;
import ru.stqa.hometask.addressbook.model.SecondaryInfoData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitNewContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void secondaryInfoFill(SecondaryInfoData secondaryInfoData) {
    type(By.name("address2"), secondaryInfoData.getSecondaryAddress());
    type(By.name("notes"), secondaryInfoData.getNotes());
  }

  public void phoneInfoFill(PhoneInfoData phoneInfoData) {
    type(By.name("home"), phoneInfoData.getHomePhone());
    type(By.name("mobile"), phoneInfoData.getMobilePhone());
    type(By.name("work"), phoneInfoData.getWorkPhone());
    type(By.name("fax"), phoneInfoData.getFax());
  }

  public void primaryInfoFill(PrimaryInfoData primaryInfoData) {
    type(By.name("firstname"), primaryInfoData.getFirstName());
    type(By.name("middlename"), primaryInfoData.getMiddleName());
    type(By.name("lastname"), primaryInfoData.getLastName());
    type(By.name("nickname"), primaryInfoData.getNickName());
    type(By.name("title"), primaryInfoData.getTitle());
    type(By.name("company"), primaryInfoData.getCompany());
    type(By.name("address"), primaryInfoData.getAddress());

  }

  public void initNewContactCreation() {
    click(By.linkText("add new"));
  }
}
