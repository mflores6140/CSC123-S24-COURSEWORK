import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileScanner2 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\angel\\csc123-s24-mywork\\currencies.csv";
        Map<String, Currency> currencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) { // each line has 3 fields
                    String currencyCode = parts[0];
                    String currencyDescription = parts[1];
                    double exchangeRate = Double.parseDouble(parts[2]);
                    Currency currency = new Currency(currencyCode, currencyDescription, exchangeRate);
                    currencyMap.put(currencyCode, currency);
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print HashMap
        for (Map.Entry<String, Currency> entry : currencyMap.entrySet()) {
            String currencyCode = entry.getKey();
            Currency currency = entry.getValue();
            System.out.println(currencyCode + " | " + currency.getCurrencyDescription() + " | " + currency.getExchangeRate());
        }
    }
}