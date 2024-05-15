import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class NetworkCurrencyLoader extends AbstractCurrencyLoader {

    private static final String EXCHANGE_RATE_URL = "http://www.usman.cloud/banking/exchange-rate.csv";

    @Override
    public InputStream getStream() throws IOException {
        URL url = new URL(EXCHANGE_RATE_URL);
        URLConnection connection = url.openConnection();
        return connection.getInputStream();
    }

    @Override
    public Map<String, Double> loadCurrencies() throws IOException {
        Map<String, Double> currencyMap = new HashMap<>();
        try (InputStream inputStream = getStream()) {
            System.out.println("Data retrieved successfully from the network.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) { // Ensure we have three parts
                    String currencyName = parts[0].trim(); // Currency abbreviation
                    double exchangeRate = Double.parseDouble(parts[2].trim()); // Exchange rate
                    currencyMap.put(currencyName, exchangeRate);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from network: " + e.getMessage());
            throw e;
        }
        return currencyMap;
    }
}
