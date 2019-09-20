package com.areaofit.netty.bio;

import java.io.*;
import java.net.Socket;

public class Client {

    private int port = 8080;

    public Client(int port) {
        this.port = port;
    }

    public void request() {
        Socket socket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            socket = new Socket("127.0.0.1", port);
            System.out.println("### 客户端开始请求 ###");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是Areaofit.\n");
            bufferedWriter.flush();
            String response = bufferedReader.readLine();
            System.out.println("response：" + response);
            System.out.println("### 客户端请求结束 ###");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
