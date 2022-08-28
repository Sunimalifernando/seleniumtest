package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArticleListViewPage;
import pages.HomePage;
import pages.ArticleDetailsPage;

public class UiTest extends BaseTest
{
  @Test(description = "This test case verifies that User is able to create a new article")
  public void createNewArticle()
  {
    HomePage homePage = new HomePage(getDriver());
    getSignInToApplication(homePage, "user1@gmail.com", "user123");
    fillNewArticleForm(homePage, "Article S", "Article S description", "Article S body", "selenium");
    //verify that article creation is successful is visible under My posts
    homePage.clickOnHomeButton().
      clickOnUserProfile("usersunimali");
    Assert.assertTrue(new ArticleListViewPage(getDriver()).isArticlePresent("Article S"), "Article not found");
    logout(homePage, "usersunimali");
  }

  @Test(description = "This test case verifies that User is able to read an article selected from Global feed")
  public void readArticleFromGlobalFeed()
  {
    HomePage homePage = new HomePage(getDriver());
    ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage(getDriver());
    getSignInToApplication(homePage, "user1@gmail.com", "user123");
    fillNewArticleForm(homePage,
                       "Article for Gloabal Feed",
                       "Article for Gloabal Feed description",
                       "Article for Gloabal Feed body",
                       "selenium");
    new HomePage(getDriver()).clickOnHomeButton().selectTab("Global Feed");
    new ArticleListViewPage(getDriver()).clickReadmoreOnArticle("Article for Gloabal Feed");
    String actualTile = articleDetailsPage.getArticleTitle();
    String actualBodyDes = articleDetailsPage.getArticleBodyDescription();
    Assert.assertEquals(actualTile, "Article for Gloabal Feed");
    Assert.assertEquals(actualBodyDes, "Article for Gloabal Feed body");
    logout(homePage, "usersunimali");
  }

  @Test(description = "This test case verifies that User is able to update an article already published by himselt")
  public void updateArticle()
  {
    ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    ArticleListViewPage articleListViewPage = new ArticleListViewPage(getDriver());
    getSignInToApplication(homePage, "user1@gmail.com", "user123");
    // Create new Article and publish
    fillNewArticleForm(homePage,
                       "My article 01",
                       "Article for Gloabal Feed description",
                       "Article for Gloabal Feed body",
                       "selenium");

    // go to my profile and select the Article needs to be edited and click on edit button
    homePage.clickOnHomeButton().
      clickOnUserProfile("usersunimali");
    articleListViewPage.clickReadmoreOnArticle("My article 01").clickEditArticleButton().

      // Update the Article and publish
        clearArticleTitle().enterTitle("Updated My article 01").
      clearArticleDescription().enterArticleDescription("Updated My article 01 description").
      clearArticleBody().enterArticleBody("Updated My article 01 body").
      clickPublishArticleButton();

    // Check the Article is updated successfully
    homePage.clickOnUserProfile("usersunimali");
    articleListViewPage.clickReadmoreOnArticle("Updated My article 01");

    String actualTile = articleDetailsPage.getArticleTitle();
    String actualBody = articleDetailsPage.getArticleBodyDescription();
    Assert.assertEquals(actualTile, "Updated My article 01");
    Assert.assertEquals(actualBody, "Updated My article 01 body");

    logout(homePage, "usersunimali");
  }

  @Test(description = "This test case verifies that User is able to delete an article already created by himself")
  public void deleteArticle()
  {
    HomePage homePage = new HomePage(getDriver());
    getSignInToApplication(homePage, "user1@gmail.com", "user123");
    fillNewArticleForm(homePage,
                       "Article for Delete",
                       "Article for delete description",
                       "Article for delete body",
                       "selenium");
    homePage.clickOnHomeButton().clickOnUserProfile("usersunimali");
    new ArticleListViewPage(getDriver()).clickReadmoreOnArticle("Article for Delete").clickDeleteButton();
    Assert
      .assertFalse(new ArticleListViewPage(getDriver()).isArticlePresent("Article for Delete"), "Article not deleted");
    logout(homePage, "usersunimali");
  }

  @Test(description = "This test case verifies that yu can read Articles by filtering using tag name")
  public void filterArticlesByTag()
  {
    HomePage homePage = new HomePage(getDriver());
    getSignInToApplication(homePage, "user1@gmail.com", "user123");
    fillNewArticleForm(homePage,
                       "Article Selenium",
                       "Article Selenium description",
                       "Article Selenium body",
                       "selenium");
    homePage.clickOnHomeButton().selectTag("selenium").selectTab("selenium");
    Assert.assertTrue(new ArticleListViewPage(getDriver()).isSelectedTagPresentInAllArticles("selenium"));
    logout(homePage, "usersunimali");
  }

  private void logout(HomePage homePage, String un)
  {
    homePage.clickOnUserProfile(un).clickOnEditProfileSettingsButton().clickOnLogoutButton();
  }

  private void getSignInToApplication(HomePage homePage, String un, String pw)
  {
    homePage.clickSignIn().
      enterUserName(un).
      enterPassword(pw).
      clickSignInButton();
  }

  private void fillNewArticleForm(HomePage homePage, String title, String description, String body, String tag)
  {
    homePage.clickOnNewArticle().
      enterTitle(title).
      enterArticleDescription(description).
      enterArticleBody(body).
      addTags(tag).
      clickPublishArticleButton();
  }
}
