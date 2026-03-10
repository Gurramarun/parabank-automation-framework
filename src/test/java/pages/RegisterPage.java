package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===============================
    // Locators
    // ===============================

    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");
    private By registerBtn = By.xpath("//input[@value='Register']");

    // SUCCESS MESSAGE
    private By successMessage = By.xpath("//div[@id='rightPanel']//p");

    // ===============================
    // Field Actions
    // ===============================

    public void enterFirstName(String fname) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterAddress(String addr) {
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(addr);
    }

    public void enterCity(String cityName) {
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cityName);
    }

    public void enterState(String stateName) {
        driver.findElement(state).clear();
        driver.findElement(state).sendKeys(stateName);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void enterPhone(String phoneNo) {
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(phoneNo);
    }

    public void enterSSN(String ssnNo) {
        driver.findElement(ssn).clear();
        driver.findElement(ssn).sendKeys(ssnNo);
    }

    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    // ===============================
    // Complete Registration Method
    // ===============================

    public void registerUser(String fname, String lname, String addr, String cityName,
                             String stateName, String zip, String phoneNo,
                             String ssnNo, String user, String pass) {

        enterFirstName(fname);
        enterLastName(lname);
        enterAddress(addr);
        enterCity(cityName);
        enterState(stateName);
        enterZipCode(zip);
        enterPhone(phoneNo);
        enterSSN(ssnNo);
        enterUsername(user);
        enterPassword(pass);
        enterConfirmPassword(pass);

        clickRegister();
    }

    // ===============================
    // Verify Registration Success
    // ===============================

    public boolean isRegistrationSuccessful() {

        return driver.findElement(successMessage)
                .getText()
                .contains("Your account was created successfully");
    }
}