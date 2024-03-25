package labs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyScanner {

    FileInputStream fis;
    boolean buffer;

    public MyScanner(String filePath) throws FileNotFoundException {
        fis = new FileInputStream(filePath);
        buffer = true;
    }

    public boolean hasNextLine() {
        return buffer;
    }

    public String nextLine() throws IOException {
        StringBuilder line = new StringBuilder();
        int nextChar;
        while ((nextChar = fis.read()) != -1) {
            char c = (char) nextChar;
            if (c == '\n') {
                break;
            }
            line.append(c);
        }
        if (nextChar == -1) {
            buffer = false;
        }
        return line.toString();
    }

    public void close() throws IOException {
        fis.close();
    }

    // Test method
    public static void main(String[] args) {
        try {
            MyScanner scanner = new MyScanner("C:\\Users\\angel\\csc123-s24-mywork\\MyFile.txt");
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println(content.toString());
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            System.err.println("Error reading file.");
        }
    }
}