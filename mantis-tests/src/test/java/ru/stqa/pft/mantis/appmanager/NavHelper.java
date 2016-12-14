package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavHelper extends HelperBase {

  public NavHelper(ApplicationManager app) {
    super(app);
  }

  public void settingsPage() {
    if (isElementPresent(By.id("manage-overview-table"))) {
      return;
    }
    click(By.cssSelector("a[href$='manage_overview_page.php']"));
  }

  public void settingsUser() {
    if (isElementPresent(By.id("manage-user-div"))) {
      return;
    }
    click(By.cssSelector("a[href$='manage_user_page.php']"));
  }
}
