package labs;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Proxy {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1203);
            while (true) {
                Socket sock = serverSocket.accept();
                ProxyWorker worker = new ProxyWorker(sock);
                worker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}