package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewArticlePage extends BasePage
{
  private By title_txtFld = By.xpath("//input[@formcontrolname='title']");
  private By description_txtFld = By.xpath("//input[@formcontrolname='description']");
  private By body_txtArea = By.xpath("//textarea[@formcontrolname='body']");
  private By tags_txt = By.xpath("//input[@placeholder='Enter tags']");
  private By publishArticle_btn = By.xpath("//button[text()=' Publish Article ']");

  public NewArticlePage(WebDriver driver)
  {
    super(driver);
  }

  public NewArticlePage enterTitle(String title)
  {
    try
    {
      driver.findElement(title_txtFld).sendKeys(title);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }

  public NewArticlePage clearArticleTitle()
  {
    driver.findElement(title_txtFld).clear();
    return this;
  }

  public NewArticlePage enterArticleDescription(String description)
  {
    try
    {
      driver.findElement(description_txtFld).sendKeys(description);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }

  public NewArticlePage clearArticleDescription()
  {
    driver.findElement(description_txtFld).clear();
    return this;
  }

  public NewArticlePage enterArticleBody(String articleBody)
  {
    try
    {
      driver.findElement(body_txtArea).sendKeys(articleBody);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }

  public NewArticlePage clearArticleBody()
  {
    driver.findElement(body_txtArea).clear();
    return this;
  }

  public NewArticlePage addTags(String tag)
  {
    try
    {
      driver.findElement(tags_txt).sendKeys(tag);
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return this;
  }

  public ArticleDetailsPage clickPublishArticleButton()
  {
    try
    {
      driver.findElement(publishArticle_btn).click();
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return new ArticleDetailsPage(getDriver());
  }
}
