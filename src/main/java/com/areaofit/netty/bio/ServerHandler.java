package com.areaofit.netty.bio;

import java.io.*;
import java.net.Socket;

/**
 * 服务端处理类
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String body;
            while (true) {
                body = bufferedReader.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("request：" + body);
                bufferedWriter.write("谢谢请求！\n");
                bufferedWriter.flush();
            }
            System.out.println("### 结束链接会话 ###");
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
