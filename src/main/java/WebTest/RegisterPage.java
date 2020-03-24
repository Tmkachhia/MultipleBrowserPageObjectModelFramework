package WebTest;

import org.openqa.selenium.By;

public class RegisterPage extends Utils
{
    LoadProp loadProp = new LoadProp();
    private By _firstName = By.cssSelector("input#FirstName");
    private By _lastName = By.cssSelector("input#LastName");
    private By _email = By.id("Email");
    private By _registerClickable = By.id("register-button");
    private By _password = By.id("Password");
    private By _confirmPassword = By.cssSelector("input#ConfirmPassword");
    private By _registerButton = By.name("register-button");
    private String timeStamp = timeStamp();

    //verify user on registration page

    public  void verifyUserIsOnRegisterPage()
    {
        assertURL("register");
    }

    public void userEnterRegistrationDetails()

    {
        sleep(1);
        //user enter all registration details
        enterText(_firstName, loadProp.getProperty("firstName"));
        enterText(_lastName ,loadProp.getProperty("lastName"));
        enterText(_email,"abcd"+timeStamp+"@gmail.com");
        enterText(_password,loadProp.getProperty("password"));
        enterText(_confirmPassword,loadProp.getProperty("confirmPassword"));
        clickOnElement(_registerButton);

    }
}
