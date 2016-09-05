package edu.csumb.cst438fa16hello.rest;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

/**
 * See:
 * http://https://docs.oracle.com/cd/E24329_01/web.1211/e24983/configure.htm#RESTF189
 * http://buraktas.com/resteasy-example-without-using-a-web-xml/
 * http://stackoverflow.com/a/26721737
 */
@ApplicationPath("rest")
public class HelloApplication extends Application {
}
