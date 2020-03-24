package WebTest;

import org.openqa.selenium.By;

public class JeweleryPage extends Utils
{
    //variables
    private By _firstJewelery = By.xpath("//div[@data-productid='40']//div[@class='details']//div//input[contains(@value,'compare ')]");
    private By _secondJewelery = By.xpath("//input[contains(@title,'compare ') and contains(@onclick,'41')]");
    private By _comparisionButton = By.xpath("//a[contains(text(),'comparison')]");
    private By _itemToRefer = By.xpath("//input[contains(@onclick,'41/2')]");
    private By _whishListButton =By.xpath("//a[contains(text(),'wishlist')]");

    //verify user on jewelery page
    public void verifyUserOnJeweleryPage()
    {
        assertURL("jewelry");
    }

    public void chooseProductToCompare()
    {

        //choose first product to compare
        sleep(1);
        clickOnElement(_firstJewelery);
        sleep(1);

        //choose second product to compare
        clickOnElement(_secondJewelery);

        sleep(1);
        //click on comparision button from green navigation bar

        sleep(1);
        clickOnElement(_comparisionButton);
    }

}
