import java.io.InputStream;
import java.util.Map;
import java.io.IOException;

public abstract class AbstractCurrencyLoader {

    public abstract InputStream getStream() throws IOException;

    public abstract Map<String, Double> loadCurrencies() throws IOException;

    public static AbstractCurrencyLoader getCurrencyLoader(String type) {
        type = type.toUpperCase().strip();
        if (type.equals("FILE")) {
            return new FileCurrencyLoader(); // Instantiate FileCurrencyLoader
        } else if (type.equals("NETWORK")) {
            return new NetworkCurrencyLoader(); // Instantiate NetworkCurrencyLoader
        }
        return null; 
    }
}
