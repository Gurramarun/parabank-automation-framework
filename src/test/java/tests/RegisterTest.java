package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.LoginPage;
import pages.HomePage;
import utils.RandomDataUtil;

public class RegisterTest extends BaseTest {

    @Test
    public void userRegistrationAndLoginTest() {

        RegisterPage registerPage = new RegisterPage(driver);

        String username = RandomDataUtil.generateUsername();
        String password = "password123";

        // Fill registration form
        registerPage.enterFirstName("Arun");
        registerPage.enterLastName("Gurram");
        registerPage.enterAddress("Hyderabad");
        registerPage.enterCity("Hyderabad");
        registerPage.enterState("Telangana");
        registerPage.enterZipCode("500001");
        registerPage.enterPhone("9876543210");
        registerPage.enterSSN("12345");

        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);

        registerPage.clickRegister();

        // Verify registration success
        Assert.assertTrue(driver.getPageSource().contains("Welcome"),
                "Registration failed!");

        // Logout
        HomePage homePage = new HomePage(driver);
        homePage.clickLogout();

        // Login again using same credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Verify login success
        Assert.assertTrue(driver.getPageSource().contains("Accounts Overview"),
                "Login failed!");
    }
}