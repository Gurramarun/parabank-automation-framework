package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.LoginPage;
import pages.HomePage;
import utils.RandomDataUtil;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    WebDriverWait wait;

    @BeforeMethod
    public void setUpWait() {
        // Initialize WebDriverWait for all tests
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void userRegistrationAndLoginTest() {
        RegisterPage registerPage = new RegisterPage(driver);

        String username = RandomDataUtil.generateUsername();
        String password = "Password123!";

        // Fill registration form
        registerPage.enterFirstName("Arun");
        registerPage.enterLastName("Gurram");
        registerPage.enterAddress("Hyderabad");
        registerPage.enterCity("Hyderabad");
        registerPage.enterState("Telangana");
        registerPage.enterZipCode("500001");
        registerPage.enterPhone("9876543210");
        registerPage.enterSSN("123456789");

        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegister();

        // Wait for registration success
        boolean registrationSuccess = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'Welcome')]")))
                .isDisplayed();

        Assert.assertTrue(registrationSuccess, "Registration failed!");

        // Logout
        HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Log out')]"))).click();

        // Login with same credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        boolean loginSuccess = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'Accounts Overview')]")))
                .isDisplayed();

        Assert.assertTrue(loginSuccess, "Login failed!");
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        String invalidUsername = RandomDataUtil.generateUsername();
        String invalidPassword = "wrongPass";

        loginPage.login(invalidUsername, invalidPassword);

        boolean errorDisplayed = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'The username and password could not be verified.')]")))
                .isDisplayed();

        Assert.assertTrue(errorDisplayed, "Error message not shown for invalid login!");
    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "existingUser"; // Use valid test user
        String password = "Password123!";

        loginPage.login(username, password);

        // Wait for login success
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'Accounts Overview')]")));

        HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Log out')]"))).click();

        // Verify user is back on login page
        boolean loginPageDisplayed = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[contains(text(),'Welcome')]")))
                .isDisplayed();

        Assert.assertTrue(loginPageDisplayed, "Logout failed!");
    }
}