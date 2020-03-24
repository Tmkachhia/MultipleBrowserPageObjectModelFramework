package WebTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    //Method to take screen shot
    public static void takeScreenShot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src\\test\\Resources\\Screenshot\\" + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Time stamp method to get unique number
    public static String timeStamp() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
    //Method for clicking on element
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

  ////Method to verify current url contains specific text so we can say user is navigated to expected page
    public static void assertURL(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    //reusable method to enter text
    public static void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Method to get text from element
    public static String getTextElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void assertTextMessage(By by,String expected, String message) {
        Assert.assertEquals(getTextElement(by), expected, message);

    }

    //method to select from drop down by text
    public void selectFromDropDownByText(By by ,String text)
    {
        Select selectText = new Select(driver.findElement(by));
        selectText.selectByVisibleText(text);
    }
    public void selectFromDropDownByValue(By by,String text) {
        Select selectValue = new Select(driver.findElement(by));
        selectValue.selectByValue(text);
    }

    public String dropDownGetSelectedText(By by)
    {
        Select select = new Select(driver.findElement(by));
        return select.getFirstSelectedOption().getText();
    }

    public void dropDrownVisibleText(By by,String text)
    { Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }





}