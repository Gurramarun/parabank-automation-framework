package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===============================
    // Locators
    // ===============================

    private By logoutLink = By.linkText("Log Out");

    // ===============================
    // Actions
    // ===============================

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

}