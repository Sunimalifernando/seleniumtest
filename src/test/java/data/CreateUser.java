package data;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class CreateUser extends BaseTest
{
  @Test
  public void createUser()
  {
    HomePage homePage = new HomePage(getDriver());
    homePage.clickSignUp().enterUserName("usersuni123").enterEmail("userSuni1223@gmail.com").enterPassword("UserSuni123")
      .clickSignUpButton();
    homePage.clickOnUserProfile("usersuni123").clickOnEditProfileSettingsButton().clickOnLogoutButton();
  }
}
