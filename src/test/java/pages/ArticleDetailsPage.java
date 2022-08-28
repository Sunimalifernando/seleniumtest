package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleDetailsPage extends BasePage
{
  private By article_title = By.cssSelector(".article-page .banner h1");
  private By article_body = By.cssSelector(".article-page .article-content p");
  private By delete_btn = By.xpath("//button[text()=' Delete Article ']");
  private By update_btn = By.xpath("//a[text()=' Edit Article ']");

  public ArticleDetailsPage(WebDriver driver)
  {
    super(driver);
  }

  public String getArticleTitle()
  {
    return driver.findElement(article_title).getText();
  }

  public String getArticleBodyDescription()
  {
    return driver.findElement(article_body).getText();
  }

  public NewArticlePage clickEditArticleButton()
  {
    driver.findElement(update_btn).click();
    return new NewArticlePage(getDriver());
  }

  public HomePage clickDeleteButton()
  {
    driver.findElement(delete_btn).click();
    return new HomePage(getDriver());
  }

}
