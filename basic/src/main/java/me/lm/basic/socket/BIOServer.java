package me.lm.basic.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by blue_ann on 14/12/2018.
 */
public class BIOServer {

    @Test
    public void serverOneThread() throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8080);     //1
        try {
            for (; ; ) {
                final Socket clientSocket = serverSocket.accept();    //2
                System.out.println("Accepted connection from " + clientSocket);
                OutputStream out;
                try {
                    out = clientSocket.getOutputStream();
                    out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));      //3
                    out.flush();
                    clientSocket.close();                //4
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        clientSocket.close();
                    } catch (IOException ex) {
                        // ignore on close
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serverMultiThread() throws IOException {
        final ServerSocket socket = new ServerSocket(8080);     //1
        try {
            for (; ; ) {
                final Socket clientSocket = socket.accept();    //2
                System.out.println("Accepted connection from " + clientSocket);

                //3
                new Thread(() -> {
                    OutputStream out;
                    try {
                        out = clientSocket.getOutputStream();
                        out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));                            //4
                        out.flush();
                        clientSocket.close();                //5

                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            clientSocket.close();
                        } catch (IOException ex) {
                            // ignore on close
                        }
                    }
                }).start();                                        //6
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serverThreadPool() throws IOException {
        final ServerSocket socket = new ServerSocket(8080);     //1
        ExecutorService executorService = Executors.newFixedThreadPool(3);//2
        try {
            for (; ; ) {
                final Socket clientSocket = socket.accept();    //3 阻塞
                System.out.println("Accepted connection from " + clientSocket);

                //4
                executorService.submit(() -> {
                    OutputStream out;
                    try {
                        out = clientSocket.getOutputStream();
                        out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));                            //5
                        out.flush();
                        clientSocket.close();                //6

                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            clientSocket.close();
                        } catch (IOException ex) {
                            // ignore on close
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
