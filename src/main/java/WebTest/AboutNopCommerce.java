package WebTest;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AboutNopCommerce extends Utils {

    LoadProp loadProp = new LoadProp();
    private By _commentTitle = By.cssSelector("input[id*='NewComment']");
    private By _addComment = By.cssSelector("textarea[id*='Comment']");
    private By _clickOnNewComment = By.cssSelector("input[value*='New comment']");
    private By _commentAddedMsg = By.cssSelector("div.result");
    private By _listOfComments = By.cssSelector("div.comments");

    public void verifyUserIsOnAboutNopCommercePage() {
        assertURL("about-nopcommerce");
    }

    public void addComments() {

        //user enter comment title
        enterText(_commentTitle, "About NopCommerce");

        //user add comments
        enterText(_addComment, "Very good website super");

        //click on new comment button
        clickOnElement(_clickOnNewComment);
    }

    public void verifyCommentaAdded()
    {
        //user able to see message-expected from load prop and actual from web page
        Assert.assertEquals(getTextElement(_commentAddedMsg), loadProp.getProperty("commentSuccessMessage"), "Result not match please check");

    }
}