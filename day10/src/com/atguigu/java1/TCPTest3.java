package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
实现TCP的网络编程

 */
public class TCPTest3 {

    /*
    这里涉及的异常还是需要try-catch，这里throws偷懒
     */
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("disney.jpeg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        // 关闭数据输出，告知服务器端数据传完了
        socket.shutdownOutput();
        // 接受来自于服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len1 = is.read(buffer1)) != -1) {
            baos.write(buffer1, 0, len1);
        }
        System.out.println(baos.toString());
        fis.close();
        os.close();
        socket.close();
        baos.close();
    }

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("disney2.jpeg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        System.out.println("图片传输完成");
        // 服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("Disney is so beautiful!".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
