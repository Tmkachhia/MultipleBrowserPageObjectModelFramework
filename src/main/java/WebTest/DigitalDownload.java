package WebTest;

import org.openqa.selenium.By;

public class DigitalDownload extends Utils
{
    private By _clickOnIfYouWaitProduct = By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/a/img");
        //User verify that navigated to digital download page
    public void verifyUserIsOnDigitalDownloadPage() {
        assertURL("digital-downloads");
    }
    //User click on item
    public void clickOnIfYouWaitProduct() {
        clickOnElement(_clickOnIfYouWaitProduct);
    }
}
