package tests;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
    WebDriver driver;
    private static final String CUSTOMERS_URL = "http://customerstestpage.s3-website.eu-west-2.amazonaws.com";

    public BaseTest() {
        driver = new SafariDriver();
        driver.get(CUSTOMERS_URL);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}