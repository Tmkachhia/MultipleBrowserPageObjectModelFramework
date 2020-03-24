package WebTest;

import org.openqa.selenium.By;

public class OnePageCheckOut extends Utils
{
    LoadProp loadProp = new LoadProp();
    By _firstName = By.xpath("//input[contains(@id,'_FirstName')]");
    By _lastName = By.xpath("//input[contains(@id,'_LastName')]");
    By _email = By.xpath("//input[contains(@id,'_Email')]");
    By _country = By.xpath("//select[contains(@id,'_CountryId')]");
    By _city = By.xpath("//input[contains(@id,'_City')]");
    By _address1 = By.cssSelector("input[id*='Address1']");
    By _postCode = By.xpath("//input[contains(@id,'_Zip')]");
    By _phoneNumber = By.xpath("//input[contains(@id,'_Phone')]");
    By _continue = By.xpath("//input[@title='Continue']");
    By _clickOnContinueCard = By.cssSelector("input[class*='payment-method']");
    By _clickOnContinuePaymentInfo = By.cssSelector("input[class*='payment-info']");
    By _clickOnConfirm = By.cssSelector("input[class*='confirm']");

    String firstName = loadProp.getProperty("firstName");
    String lastName = loadProp.getProperty("lastName");
    String email = loadProp.getProperty("email");
    String country = loadProp.getProperty("country");
    String city = loadProp.getProperty("city");
    String address1 = loadProp.getProperty("address1");
    String postCode = loadProp.getProperty("postCode");
    String phoneNumber = loadProp.getProperty("PhoneNumber");

    public void guestEnterDetails() {
        enterText(_firstName, firstName);
        enterText(_lastName, lastName);
        enterText(_email, email);
        selectFromDropDownByText(_country, country);
        enterText(_city, city);
        enterText(_address1, address1);
        enterText(_postCode, postCode);
        enterText(_phoneNumber, phoneNumber);
    }

    public void clickOnContinue() {
        clickOnElement(_continue);
        clickOnElement(_clickOnContinueCard);
        clickOnElement(_clickOnContinuePaymentInfo);
    }
    public void clickOnConfirm()
    {
        clickOnElement(_clickOnConfirm);
    }
}
