package WebTest;

import org.openqa.selenium.By;

public class EmailAFriend extends Utils
{
    LoadProp loadProp = new LoadProp();
    private By _friendEmail = By.id("FriendEmail");
    private By _sendEmail = By.name("send-email");
    private By _actualMessageRegistered =By.className("result");
    private By _notRegisterActual = By.id("YourEmailAddress-error");
    private By _personalMessage = By.cssSelector("textarea#PersonalMessage");

    private String friendEmail=loadProp.getProperty("friendEmail");
    private String personalMessage= loadProp.getProperty("personalMessage");
    private String registeredUserMessage = loadProp.getProperty("registeredExpectedMessage");
    private String notRegisteredExpected = loadProp.getProperty("notRegisterExpected");



    //enter friend's email address
    public void enterEmailAddressOfFriend()
    {
        enterText(_friendEmail,friendEmail);
        enterText(_personalMessage,personalMessage);
    }
    //click on send email key
    public void sendEmailToFriend(){
        clickOnElement(_sendEmail);
    }

    //Assert to verify registered user see email sent message
    public void verifyUserSeeEmailSentMessage(){
        assertTextMessage(_actualMessageRegistered,registeredUserMessage,"FAIL CHECK");
    }

    //Assert to check non registered user see message
    public void verifyNotRegisterUserSeeErrorMessage()
    {
        assertTextMessage(_notRegisterActual,notRegisteredExpected,"TEST FAIL CHECK");
    }

}
