package com.areaofit.netty.bio;

public class Test {

    @org.junit.Test
    public void testServer() {
        Server server = new Server(8080);
        server.start();
    }

    @org.junit.Test
    public void testClient() {
        Client client = new Client(8080);
        client.request();
    }
}
