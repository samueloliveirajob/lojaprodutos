package integration.shared;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.loja.boot.server.ApplicationServer;
import br.com.loja.boot.server.WebServer;


public class IntegrationServer {

	public static WebServer server;
    public static int jettyPort;

    @BeforeClass
    public static void serverStart() throws Exception {
        server = new ApplicationServer();
        server.start();
        jettyPort = server.portNUmber();
    }

    @AfterClass
    public static void serverDestroy() throws Exception {
        server.stop();
    }

	/**
	 * @return the server
	 */
	public WebServer getServer() {
		return server;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(WebServer server) {
		this.server = server;
	}

	/**
	 * @return the jettyPort
	 */
	public int getJettyPort() {
		return jettyPort;
	}

	/**
	 * @param jettyPort the jettyPort to set
	 */
	public void setJettyPort(int jettyPort) {
		this.jettyPort = jettyPort;
	}
    
    
}
