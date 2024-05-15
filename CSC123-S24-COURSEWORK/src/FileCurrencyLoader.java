import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FileCurrencyLoader extends AbstractCurrencyLoader {

    @Override
    public Map<String, Double> loadCurrencies() throws IOException {
        Map<String, Double> currencyMap = new HashMap<>();
        File file = new File("C:\\Users\\angel\\csc123-s24-mywork\\currencies.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String currencyName = parts[0].trim();
                    double exchangeRate = Double.parseDouble(parts[1].trim());
                    currencyMap.put(currencyName, exchangeRate);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            throw e;
        }
        return currencyMap;
    }

    @Override
    public InputStream getStream() throws IOException {
        // Implement if needed, not used in this loader
        return null;
    }
}