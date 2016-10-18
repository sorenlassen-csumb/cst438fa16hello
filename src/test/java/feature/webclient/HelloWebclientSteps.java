package feature.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWebclientSteps {
    WebDriver driver = new PhantomJSDriver();

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    @Given("^I am on the (\\w+) page$")
    public void i_am_on_the_hello_page(String pageName) throws Throwable {
        driver.get("http://localhost:8080/" + pageName + ".html");
    }

    @When("^I enter \"([^\"]*)\"$")
    public void i_enter(String name) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see the greeting \"([^\"]*)\"$")
    public void i_see_the_greeting(String greeting) throws Throwable {
        // The greeting is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("greet"), greeting));
    }

    @Then("^I see an error message$")
    public void i_see_an_error_message() throws Throwable {
        // The greeting is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBePresentInElementLocated(By.id("greet"), "error:"));
    }
}
