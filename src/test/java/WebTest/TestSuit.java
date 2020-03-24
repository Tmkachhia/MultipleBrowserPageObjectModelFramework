package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuit extends BaseSuit {
    // these are objects created of classes to call reusable methods
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    JeweleryPage jeweleryPage = new JeweleryPage();
    JeweleryPageComparision jeweleryPageComparision = new JeweleryPageComparision();
    LoginPage loginPage = new LoginPage();
    ComputerPage computerPage = new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    ReferProduct referProduct = new ReferProduct();
    EmailAFriend emailAFriend = new EmailAFriend();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    CameraPhotosPage cameraPhotosPage = new CameraPhotosPage();
    DigitalDownload digitalDownload = new DigitalDownload();
    IfYouWaitProduct ifYouWaitProduct = new IfYouWaitProduct();
    CartPage cartPage = new CartPage();
    CheckOutAsGuest checkOutAsGuest = new CheckOutAsGuest();
    OnePageCheckOut onePageCheckOut = new OnePageCheckOut();
    CheckOutCompleted checkOutCompleted = new CheckOutCompleted();
    AboutNopCommerce aboutNopCommerce = new AboutNopCommerce();


    @Test //1
    public void userShouldAbleToRegisterSuccessfully() {
        //click on Register button
        homePage.clickOnRegisterButton();

        //verify user is on Register page
        registerPage.verifyUserIsOnRegisterPage();

        //user enter all Registration details
        registerPage.userEnterRegistrationDetails();

        //user able to see success message
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
    }

    @Test//2
    public void userShouldBeAbleToCompareTwoDifferentProductSuccessfully() {
        //calling method to click on jewelery
        homePage.clickOnJewelery();

        //Verify user on jewelery category page
        jeweleryPage.verifyUserOnJeweleryPage();

        //user select products to compare
        jeweleryPage.chooseProductToCompare();

        //user should be navigated to comparision page
        jeweleryPageComparision.verifyUserIsOnJeweleryComparisionPage();

    }

    @Test//3
    public void registeredUserShouldAbleToReferProductToFriend() {
        //user click on login button
        homePage.clickOnLogin();

        //user enter login details
        loginPage.userEnterLoginDetails();

        //user selecting product to refer friend
        homePage.clickOnComputer();
        computerPage.clickOnDesktop();
        desktopPage.userSelectItemToReferFriend();

        //user enter friend's email address
        referProduct.emailProduct();
        emailAFriend.enterEmailAddressOfFriend();
        emailAFriend.sendEmailToFriend();

        //user able to see email sent message
        emailAFriend.verifyUserSeeEmailSentMessage();
    }

    @Test//4
    public void notRegisteredUserCanNotReferItemToFriend() {
        //user select product to refer friend
        homePage.clickOnComputer();
        computerPage.clickOnDesktop();
        desktopPage.userSelectItemToReferFriend();

        //user enter friend's email address
        referProduct.emailProduct();
        emailAFriend.enterEmailAddressOfFriend();
        emailAFriend.sendEmailToFriend();

        //user can see message
        emailAFriend.verifyNotRegisterUserSeeErrorMessage();
    }

    @Test//5
    public void userShouldBeAbleToSortProductHighToLowByPrice() {    //click on electronics
        homePage.clickOnElectronics();

        //click on CameraAndPhotos category
        electronicsPage.clickOnCameraAndPhotos();

        //verify user is navigated to Camera-photos category
        cameraPhotosPage.verifyUserOnCameraAndPhotosPage();
        //selecting price from high to low from drop down
        cameraPhotosPage.useSelectFromPositionPriceHighToLow();
        cameraPhotosPage.userVerifyPriceHighToLowArranged();
    }

    @Test//6
    public void guestUserShouldAbleToCheckoutSuccessfully() {
        //verify user is on home page
        homePage.verifyUserIsOnHomePage();
        homePage.clickOnDigitalDownLoad();
        //click on digital download
        digitalDownload.verifyUserIsOnDigitalDownloadPage();
        digitalDownload.clickOnIfYouWaitProduct();
        //click on add to cart button
        ifYouWaitProduct.addToCartButtonAndShoppingCart();
        //verify user is on cart page,tick box and click on checkout
        cartPage.verifyUserIsOnCartPage();
        cartPage.clickOnTermsAndCondition();
        //verify user is on that page
        cartPage.clickOnCheckOut();
        //user verify that he is navigated to checkout as guest page  and click on check out as guest button
        checkOutAsGuest.verifyUserShouldOnCheckoutAsAGuestPage();
        checkOutAsGuest.clickOCheckoutAsGuestButton();
        //Guest user enter all details and confirm and continue
        onePageCheckOut.guestEnterDetails();
        onePageCheckOut.clickOnContinue();
        onePageCheckOut.clickOnConfirm();
        //guest user able to checkout successfully
        checkOutCompleted.userIsOnCheckoutCompletedPage();
    }

    @Test//7
    public void guestUserShouldAbleToAddNewComment() {   //User click on Details button
        homePage.clickOnDetailsButton();
        //verify user on About nop commerce page
        aboutNopCommerce.verifyUserIsOnAboutNopCommercePage();
        //user add comments
        aboutNopCommerce.addComments();
        aboutNopCommerce.verifyCommentaAdded();
    }

    @Test//8
    public void verifyUserShouldAbleToChangeCurrency() {
        //verifying default home page currency
        homePage.verifyingCurrencySymbolPresent();

    }

    @Test//9

    public void verifyAddToCartButtonPresent()
    {
        homePage.verifyAddToCartButtonPresent();

    }

}