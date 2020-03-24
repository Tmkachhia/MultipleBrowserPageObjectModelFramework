package WebTest;

import org.openqa.selenium.By;

public class CartPage extends Utils
{
    By _termsAndCondition = By.cssSelector("input#termsofservice");
    By _checkOut = By.cssSelector("button#checkout");
    private By _clickOnCheckOutAsGuest = By.xpath("//input[@onclick='location.href=\"/checkout\"']");

    public void verifyUserIsOnCartPage()
    {
        assertURL("cart");
    }
    //user tick box for accepting terms and condition
    public void clickOnTermsAndCondition()
    {
        sleep(1);
        clickOnElement(_termsAndCondition);
    }
    public void clickOnCheckOut()
    {
        clickOnElement(_checkOut);
    }
}
