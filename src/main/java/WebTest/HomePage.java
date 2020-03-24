package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePage extends Utils {
    LoadProp loadProp = new LoadProp();
    private By _registerLink = By.linkText("Register");
    private By _Jewelery = By.xpath("//ul[contains(@class,'notmobile')]//li//a[contains(text(),'Jewelry ')] ");
    private By _loginbutton = By.className("ico-login");
    private By _computer = By.xpath("//ul[contains(@class,'notmobile')]//a[contains(text(),'Computers ')]");
    private By _electronics = By.xpath("//ul[contains(@class,'notmobile')]//li/a[contains(text(),'Electronics ')]");
    private By _clickOnDigitalDownload = By.xpath("//ul[contains(@class,'not')]//a[contains(text(),'Digital')]");
    private By _clickOnDetails = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[5]/div[2]/div[3]/div[3]/a");
    private By _currencyDropDrownMenuField = By.id("customerCurrency");
    By _itemBoxesField = By.className("product-item");
    By _addCartButtonField = By.cssSelector("[type='button'][value='Add to cart']");
    By _productNameField = By.cssSelector("h2.product-title > a");


    SoftAssert softAssert = new SoftAssert();

    //verify user is on home page
    public void verifyUserIsOnHomePage() {
        assertURL("nopcommerce");
    }

    //Click on register button
    public void clickOnRegisterButton() {
        clickOnElement(_registerLink);
    }

    //click on jewelery button
    public void clickOnJewelery() {
        clickOnElement(_Jewelery);
    }

    //click on login button
    public void clickOnLogin() {
        clickOnElement(_loginbutton);
    }

    //click on computer button
    public void clickOnComputer() {
        clickOnElement(_computer);
    }

    //user click on Electronics
    public void clickOnElectronics() {
        clickOnElement(_electronics);
        sleep(1);
    }

    public void clickOnDigitalDownLoad() {
        clickOnElement(_clickOnDigitalDownload);
        sleep(2);
    }

    public void clickOnDetailsButton() {
        clickOnElement(_clickOnDetails);
    }

    public void selectCurrencyFromDropDown() {
        dropDrownVisibleText(_currencyDropDrownMenuField, loadProp.getProperty("changeToCurrency"));
    }

    public void verifyingCurrencySymbolPresent() {
        String selectedCurrencyName = dropDownGetSelectedText(_currencyDropDrownMenuField);
        String currencySymbol = getCurrencySymbolFromCurrencyName(selectedCurrencyName);

        List<WebElement> listOfPriceElements = driver.findElements(By.xpath("//span[@class='price actual-price']"));
        for (WebElement element : listOfPriceElements) {
            softAssert.assertTrue(element.getText().contains(currencySymbol), "This price does not have selected currency symbol " + currencySymbol);
            softAssert.assertAll();
        }

    }

    public String getCurrencySymbolFromCurrencyName(String currencyName) {
        switch (currencyName) {
            case "US Dollar":
                return "$";
            case "Euro":
                return "Ђ";
            default:
                return "Invalid Currency name";
        }

    }
        public void verifyAddToCartButtonPresent () {


            List<WebElement> webElementList = driver.findElements(_itemBoxesField);
            int count = 0;
            for (WebElement element : webElementList) {
                //finding add tocart element present in each product box
                if (element.findElements(_addCartButtonField).size() == 1) {
                    //adding add to cart button for counting
                    count++;
                } else {
                    //if add to cart element not present, then printing product title/name from that product box
                    System.out.println(" " + "NO ADD TO CART BUTTON >>>>>>> " + element.findElement(_productNameField).getText());
                }
            }
            Assert.assertEquals(count,webElementList.size(),"Sorry fail");

        }
}


