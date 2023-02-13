package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.DashBoardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    DashBoardPage dashboard;


    @BeforeMethod
    public void inIT() {
        loginPage = new LoginPage();
        homePage=new HomePage();
        dashboard = new DashBoardPage();
    }
    @Test
    public void verifyUserShouldLoginSuccessFully() throws InterruptedException {
        loginPage.enterUserName("Admin");
        Thread.sleep(1000);
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Thread.sleep(500);
        String expected="Paul Collings";
        Assert.assertEquals(homePage.verifyWelcomeText(),expected);
    }
    @Test
    public void verifyThatTheLogoDisplayOnHomePage() throws InterruptedException {
        loginPage.enterUserName("Admin");
        Thread.sleep(1000);
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.verifyLogo());
    }
    @Test
    public void verifyUserShouldLogOutSuccessFully() throws InterruptedException {
        loginPage.enterUserName("Admin");
        Thread.sleep(1000);
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Thread.sleep(1000);
        homePage.clickOnProfilePhoto();

        homePage.clickOnLogoutButton();
        Assert.assertTrue(homePage.verifyLoginpanel());




    }
}/*Click on User Profile logo
    Mouse hover on "Logout" and click
        Verify the text "Login" is displayed*/
