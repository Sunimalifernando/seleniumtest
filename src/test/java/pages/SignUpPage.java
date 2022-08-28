package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage
{
  private By useName_txtField = By.xpath("//input[@formcontrolname='username']");
  private By email_txtFld = By.xpath("//input[@formcontrolname='email']");
  private By password_txtFld = By.xpath("//input[@formcontrolname='password']");
  private By signIn_btn = By.xpath("//button[text()=' Sign up ']");

  public SignUpPage(WebDriver driver)
  {
    super(driver);
  }

  public SignUpPage enterUserName(String userName)
  {
    try
    {
      driver.findElement(useName_txtField).sendKeys(userName);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }
  public SignUpPage enterEmail(String userName)
  {
    try
    {
      driver.findElement(email_txtFld).sendKeys(userName);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }

  public SignUpPage enterPassword(String password)
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

  public HomePage clickSignUpButton()
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
