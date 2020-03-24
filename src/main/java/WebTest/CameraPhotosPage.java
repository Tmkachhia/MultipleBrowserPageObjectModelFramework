package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CameraPhotosPage extends Utils {
    public void verifyUserOnCameraAndPhotosPage() {
        assertURL("camera-photo");
    }

    private By _dropDown = By.id("products-orderby");
    private String priceHighToLOw = "Price: High to Low";

    //user select price high to low from drop down box
    public void useSelectFromPositionPriceHighToLow() {
        selectFromDropDownByText(_dropDown, priceHighToLOw);
    }

    //user verify prices are arranged from high to low
    public void userVerifyPriceHighToLowArranged() {
        //getting value from web page
        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='price actual-price']"));


        //declare ArrayList to store value from web page in string
        ArrayList<String> WebSortedPrice = new ArrayList<String>();
        //declare ArrayList to sort value in double
        ArrayList<Double> DoubleWebSortedPrice = new ArrayList<Double>();

        //Adding value to WebSortedPrice which we get from web page removing non numeric and ,
        for (int i = 0; i < priceList.size(); i++) {
            WebSortedPrice.add(priceList.get(i).getText().replaceAll("[^0-9.]", ""));

        }
        //Printing list from sorted from web page
        System.out.println("String sorted list from web page " + WebSortedPrice);
        for (String s : WebSortedPrice) {
            //converting string value to double
            DoubleWebSortedPrice.add(Double.valueOf(s));
        }
        //Printing double value
        System.out.println("Double sorted list from web page is " + DoubleWebSortedPrice);


        for (int m = 0; m < DoubleWebSortedPrice.size(); m++) {
            for (int n = m + 1; n < DoubleWebSortedPrice.size(); n++) {
                if (DoubleWebSortedPrice.get(m) >= DoubleWebSortedPrice.get(n)) {
                    //checking first value is greater than next
                    System.out.println("Price Sorted");
                } else {
                    System.out.println("Price Not Sorted");
                }
            }
        }
    }



}
