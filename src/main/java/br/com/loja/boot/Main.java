package br.com.loja.boot;

import br.com.loja.boot.server.ApplicationServer;
import br.com.loja.boot.server.WebServer;

public class Main {

    public static void main(String[] args) throws Exception {
        WebServer server = new ApplicationServer();
        server.start();
    }
}
