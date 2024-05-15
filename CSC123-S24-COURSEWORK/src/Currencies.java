import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Currencies {

    private Map<String, MyCurrency> currencies;

    // Constructor with AbstractCurrencyLoader parameter
    public Currencies(AbstractCurrencyLoader loader) {
        try {
            currencies = new HashMap<>();
            Map<String, Double> currencyMap = loader.loadCurrencies();
            for (String key : currencyMap.keySet()) {
                MyCurrency c = new MyCurrency(key, currencyMap.get(key));
                this.currencies.put(key, c);
            }
        } catch (IOException e) {
            System.out.println("Error loading currencies: " + e.getMessage());
        }
    }

    // Existing constructor without loader
    public Currencies() {
        currencies = new HashMap<>();
        currencies.put("USD", new MyCurrency("USD", 1.0));
        currencies.put("CAD", new MyCurrency("CAD", 0.75));
        // Add more currencies if needed
    }

    public MyCurrency getCurrency(String name) {
        return currencies.get(name);
    }

    public boolean existsCurrency(String name) {
        return currencies.containsKey(name);
    }
}