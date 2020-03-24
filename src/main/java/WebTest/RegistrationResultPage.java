package WebTest;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils
{
    private String expected = "Your registration completed";
    private By _actualRegistrationSuccessMessage = By.cssSelector("div.result");

    public void verifyUserSeeRegistrationSuccessMessage()
    {
        //verify user is on RegistrationResult page
        assertURL("registerresult");

        //Assert to check registration complete message
        Assert.assertEquals(getTextElement(_actualRegistrationSuccessMessage),expected,"TEST FAIL PLEASE CHECk");

    }
}
