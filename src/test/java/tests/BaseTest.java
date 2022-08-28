package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
  WebDriver driver;

  @BeforeClass
  public void setDriver()
  {

    //System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    String username = "candidatex";
    String password = "qa-is-cool";
    String URL = "https://" + username + ":" + password + "@" + "qa-task.backbasecloud.com";
    driver.get(URL);

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    Reporter.log("========Application Started=======",true);

  }

  @AfterClass
  public void afterTest()
  {
    driver.quit();
    Reporter.log("========Browser Session End=======",true);

  }

    public WebDriver getDriver() {
      return driver;
    }

}
