package WebTest;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckOutCompleted extends Utils
{
    LoadProp loadProp = new LoadProp();
    private By _successMsgFromActual = By.xpath("//strong[contains(text(),'successfully processed!')]");

    public void userIsOnCheckoutCompletedPage()
    {
        Assert.assertEquals(getTextElement(_successMsgFromActual),loadProp.getProperty("CheckoutSuccessMsg"),"\" Test fail please check expected not match actual \"");
    }
}
