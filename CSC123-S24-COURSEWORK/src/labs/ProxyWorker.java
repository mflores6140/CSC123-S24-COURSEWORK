package labs;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxyWorker extends Thread {
    private Socket sock;

    public ProxyWorker(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try {
            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();
            
            String httpRequest = "GET / \n";
            
            writeData(out, httpRequest);
            
            String response = readData(in);
            System.out.println("Server said: " + response);
            
            Socket clientSock = new Socket("www.google.com", 80);
            OutputStream outInternet = clientSock.getOutputStream();
            InputStream inInternet = clientSock.getInputStream();
            
            outInternet.write(httpRequest.getBytes());
            outInternet.write('\n');
            outInternet.flush();
            
            String internetResponse = readData(inInternet);
            System.out.println("Google said: " + internetResponse);
            
            sock.close();
            clientSock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeData(OutputStream out, String data) throws IOException {
        out.write(data.getBytes());
        out.write('\n');
        out.flush();
    }

    public static String readData(InputStream in) throws IOException {
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