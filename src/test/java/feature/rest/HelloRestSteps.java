package feature.rest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import edu.csumb.cst438fa16hello.rest.HelloService;

public class HelloRestSteps extends JerseyTest {
    Response response;

    @Override
    protected Application configure() {
        return new ResourceConfig(HelloService.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @When("^I call (\\w+) endpoint with \"([^\"]*)\"$")
    public void i_call_hello_endpoint_with(String endpoint, String name) throws Throwable {
        WebTarget webTarget = target(endpoint).queryParam("name", name);
        response = webTarget.request().get();
    }

    @Then("^the reponse status code is (\\d+)$")
    public void the_reponse_status_code_is(int code) throws Throwable {
        assertThat(response.getStatus(), equalTo(code));
    }

    @Then("^the message body is \"([^\"]*)\"$")
    public void the_message_body_is(String msg) throws Throwable {
        assertThat(response.readEntity(String.class), equalTo(msg));
    }
}
