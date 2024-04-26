package labs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 1203);

            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

            String httpRequest = "GET / \n";

            writeData(out, httpRequest);

            String response = readData(in);
            System.out.println("Server said: " + response);

            sock.close();
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

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = "";
        StringBuilder output = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        return output.toString();
    }
}