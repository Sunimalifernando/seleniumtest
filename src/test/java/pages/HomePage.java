package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class HomePage extends BasePage
{
  private By home_btn = By.linkText("Home");
  private By signIn_btn = By.linkText("Sign in");
  private By signUp_btn = By.linkText("Sign up");
  private By newArticle_btn = By.partialLinkText("New Article");

  public HomePage(WebDriver driver)
  {
    super(driver);
  }

  public SignInPage clickSignIn()
  {
    try
    {
      driver.findElement(signIn_btn).click();
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      System.out.println("Exception caught" + e.getMessage());
    }
    return new SignInPage(getDriver());
  }

  public SignUpPage clickSignUp()
  {
    try
    {
      driver.findElement(signUp_btn).click();
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      System.out.println("Exception caught" + e.getMessage());
    }

    return new SignUpPage(getDriver());
  }

  public void selectTab(String tabName)
  {
    if(isTabDisplayed(tabName))
    {
      try
      {
        driver.findElement(By.linkText(tabName)).click();
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    else
      Reporter.log("Tab not present in the HomePage");
  }

  public NewArticlePage clickOnNewArticle(){
    driver.findElement(newArticle_btn).click();
    return new NewArticlePage(getDriver());
  }

  public UserProfilePage clickOnUserProfile(String text){
    try
    {
      driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]")).click();
      Thread.sleep(4000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return new UserProfilePage(getDriver());
  }

  public HomePage clickOnHomeButton()
  {
    driver.findElement(home_btn).click();
    return this;
  }

  public HomePage selectTag(String tagName){
    driver.findElement(By.xpath("//div[@class='tag-list']//a[text()=' "+tagName+" ']")).click();
    return this;
  }

  public boolean isTabDisplayed(String tabName){
    return driver.findElement(By.xpath("//a[text()=' "+tabName+" ']")).isDisplayed();
  }
}
