package WebTest;

public class JeweleryPageComparision extends Utils
{
    //method to confirm user navigated to comparision page
    public void verifyUserIsOnJeweleryComparisionPage()
    {
        assertURL("compareproducts");

    }
}

