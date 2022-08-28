package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage
{
  private By username_txtFld = By.xpath("//input[@formcontrolname='email']");
  private By password_txtFld = By.xpath("//input[@formcontrolname='password']");
  private By signIn_btn = By.xpath("//button[text()=' Sign in ']");

  public SignInPage(WebDriver driver)
  {
    super(driver);
  }

  public SignInPage enterUserName(String userName)
  {
    try
    {
      driver.findElement(username_txtFld).sendKeys(userName);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }

  public SignInPage enterPassword(String password)
  {
    try
    {
      driver.findElement(password_txtFld).sendKeys(password);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }

  public HomePage clickSignInButton()
  {
    try
    {
      driver.findElement(signIn_btn).click();
      Thread.sleep(9000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return new HomePage(getDriver());
  }
}
