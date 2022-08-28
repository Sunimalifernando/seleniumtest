package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticleListViewPage extends BasePage
{

  public ArticleListViewPage(WebDriver driver)
  {
    super(driver);
  }

  public ArticleDetailsPage clickReadmoreOnArticle(String articleTitle)
  {
    try
    {
      driver.findElement(By.xpath("(//h1[text()='" + articleTitle + "']//following-sibling::span[text()='Read more...'])[1]")).click();
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return new ArticleDetailsPage(getDriver());
  }

  public boolean isArticlePresent(String titleExpec)
  {
    List<WebElement> listTitle = driver.findElements(By.xpath("//a[@class='preview-link']//h1"));
    boolean found = false;
    for(WebElement title:listTitle)
      if(title.getText().contains(titleExpec))
      {
        found=true;
        break;
      }
    return found;
  }

    public boolean isSelectedTagPresentInAllArticles(String tagExpec){
      boolean find = true;
      // identify elements
      List<WebElement> listTag= driver.findElements(By.xpath("//h1[text()='"+tagExpec+"'] "));
      for(WebElement title:listTag)
        if(!title.getText().contains(tagExpec))
        {
          find=false;
          break;
        }
        return find;
    }
}
