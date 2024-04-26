package labs;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1203);
            while (true) {
                Socket sock = server.accept();
                Worker worker = new Worker(sock);
                worker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Worker extends Thread {
    private Socket sock;

    public Worker(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try {
            Socket clientSock = new Socket("www.google.com", 80);
            OutputStream outInternet = clientSock.getOutputStream();
            InputStream inInternet = clientSock.getInputStream();

            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();

            String clientRequest = readData(in);

            outInternet.write(clientRequest.getBytes());
            outInternet.write('\n');
            outInternet.flush();

            String internetResponse = readData(inInternet);

            String clientResponse = "You said: " + internetResponse;
            writeData(out, clientResponse);

            sock.close();
            clientSock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(OutputStream out, String data) throws IOException {
        out.write(data.getBytes());
        out.write('\n');
        out.flush();
    }

    private static String readData(InputStream in) throws IOException {
        int byteRead;
        StringBuilder output = new StringBuilder();

        while ((byteRead = in.read()) != -1) {
            if (byteRead == '\n') {
                break;
            }
            output.append((char) byteRead);
        }
        return output.toString();
    }
}