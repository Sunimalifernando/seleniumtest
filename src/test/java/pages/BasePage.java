package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
  private static final int TIMEOUT = 5;

  protected WebDriver driver;
  private WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  protected void waitForElementToAppear(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected void waitForElementToDisappear(By locator) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  protected void waitForTextToDisappear(By locator, String text) {
    wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
  }
}
