package integration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import br.com.loja.boot.server.ApplicationServer;
import br.com.loja.boot.server.WebServer;

/**
 * Created by STELO\renato.5a on 9/19/17.
 */
public class JettyStarter {

    WebServer server;
    public static int jettyPort =9000;

    @BeforeSuite
    public void init() throws Exception {
        server = new ApplicationServer();
        server.start();
        jettyPort = server.portNUmber();
    }

    @AfterSuite
    public void destroy() throws Exception {
        server.stop();
    }
}
