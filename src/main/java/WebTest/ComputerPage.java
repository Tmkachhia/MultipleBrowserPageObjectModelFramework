package WebTest;

import org.openqa.selenium.By;

public class ComputerPage extends Utils
{
    private By _desktop = By.xpath("//li[@class='inactive']//a[contains(@href,'desktops')]");

    public void verifyUserOnComputerPage()
    {
        assertURL("computers");
    }

    //click on desktop
    public void clickOnDesktop()
    {
        sleep(1);
        clickOnElement(_desktop);
    }
}
