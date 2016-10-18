package edu.csumb.cst438fa16hello.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *   As a user I want to be greeted by the name of my choice to become amused
 *
 * Class name ends in IT so it runs with "mvn integration-test", not "mvn test".
 */
public class HelloIT {
    // Requires phantomjs. See:
    // http://phantomjs.org/download.html
    // On Mac you can install it with "brew install phantomjs" if you have Homebrew.
    // CircleCI has it: https://circleci.com/docs/build-image-trusty/
    WebDriver driver = new PhantomJSDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/hello.html");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    /**
     * Acceptance test:
     *
     *   Given I am on the hello page
     *   When I enter "Alan"
     *   Then I see the greeting "hello Alan"
     */
    @Test
    public void testGreetsByName() {
        driver.findElement(By.id("name")).sendKeys("Alan");
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("greet"), "hello Alan"));

        // Success
    }
}
