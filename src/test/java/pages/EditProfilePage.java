package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage extends BasePage
{
  private By logout_btn = By.xpath("//button[text()=' Or click here to logout. ']");

  public EditProfilePage(WebDriver driver)
  {
    super(driver);
  }

  public HomePage clickOnLogoutButton()
  {
    driver.findElement(logout_btn).click();
    return new HomePage(getDriver());
  }

}
