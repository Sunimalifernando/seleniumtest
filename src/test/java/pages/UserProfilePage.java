package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage extends BasePage
{
  private  By editProfileSettingButton = By.xpath("//a[text()=' Edit Profile Settings ']");

  public UserProfilePage(WebDriver driver)
  {
    super(driver);
  }

  public EditProfilePage clickOnEditProfileSettingsButton() {
    driver.findElement(editProfileSettingButton).click();
    return new EditProfilePage(getDriver());
}


}
