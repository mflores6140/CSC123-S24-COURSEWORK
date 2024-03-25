import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\angel\\csc123-s24-mywork\\currencies.csv";
        List<Currency> currencies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) { // each line has 3 fields which are code, description, & exchange rate
                    String currencyCode = parts[0];// first part to hold code
                    String currencyDescription = parts[1];// second part to hold description
                    double exchangeRate = Double.parseDouble(parts[2]);// third part to hold rate
                    Currency currency = new Currency(currencyCode, currencyDescription, exchangeRate);
                    currencies.add(currency);
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for (Currency currency : currencies) {
            System.out.println(currency.getCurrencyCode() + " | " + currency.getCurrencyDescription() + " | " + currency.getExchangeRate());
        }
    }
}
