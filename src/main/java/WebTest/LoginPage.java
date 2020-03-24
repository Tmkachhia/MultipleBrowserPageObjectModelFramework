package WebTest;

import org.openqa.selenium.By;

public class LoginPage extends Utils
{
    private By _enteEemail = By.className("email");
    private By _login = By.xpath("//input[@value='Log in']");
    private By _password = By.id("Password");
    LoadProp loadProp = new LoadProp();

    public void userEnterLoginDetails()
    {
        sleep(2);
        //user enter email address
        enterText(_enteEemail,loadProp.getProperty("emailAddress"));
        //enter password
        enterText(_password,loadProp.getProperty("password"));
        sleep(1);
        //click on login
        clickOnElement(_login);
    }

}
