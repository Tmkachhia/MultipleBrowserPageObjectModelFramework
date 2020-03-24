package WebTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSuit extends Utils
{
    @BeforeMethod
    //This open browser method will run before any method run
    public void openBrowser()
    {
        BrowserSelector.setUpBrowser();
    }

    @AfterMethod

    public void closeBrowser(ITestResult result) {

        // Before driver quit this below method take screen shot if test fail
        if (!result.isSuccess())
        {
            takeScreenShot(result.getName()+timeStamp());

        }
        driver.quit();

    }
}
