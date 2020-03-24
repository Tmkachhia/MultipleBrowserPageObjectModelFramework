package WebTest;

import org.openqa.selenium.By;

public class ElectronicsPage extends Utils
{
    private By _cameraAndPhotos = org.openqa.selenium.By.xpath("//h2[@class='title']//a[contains(@title,'Camera')]");

    public void verifyUserOnElectronicsPage()
    {
        assertURL("electronics");
    }

    //click on  item cameraAndPhotos
    public void clickOnCameraAndPhotos()
    {
        clickOnElement(_cameraAndPhotos);
    }
}
