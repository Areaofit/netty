package com.areaofit.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * JDK 1.4 之前采用的同步阻塞I/O模式:并发量不大，性能不高
 *
 */
public class Server {

    private int port = 8080;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                // 阻塞直到有新的链接进来
                socket = serverSocket.accept();
                System.out.println("### 获取到新链接 ###");
                new Thread(new ServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
