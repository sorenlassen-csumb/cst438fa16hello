package edu.csumb.cst438fa16hello.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *   As a user I want to be greeted by the name of my choice to become amused
 *
 * Class name ends in IT so it runs with "mvn integration-test", not "mvn test".
 */
public class HelloIT {
    // Requires chromedriver. See:
    // http://docs.seleniumhq.org/docs/03_webdriver.jsp#chromedriver
    // On Mac you can install it with "brew install googledriver" if you have Homebrew.
    WebDriver driver = new ChromeDriver();

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
        // Sanity check: greeting is empty when the page is first loaded
        assertThat(driver.findElement(By.id("greet")).getText(), equalTo(""));

        // Enter something to search for
        driver.findElement(By.id("name")).sendKeys("Alan");

        // Now submit the form. WebDriver will find the form for us from the element
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.findElement(By.id("greet")).getText().isEmpty();
            }
        });

        assertThat(driver.findElement(By.id("greet")).getText(), equalTo("hello Alan"));
    }
}
