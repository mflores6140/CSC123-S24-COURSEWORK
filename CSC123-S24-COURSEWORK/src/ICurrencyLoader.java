import java.util.Map;

public interface ICurrencyLoader {
	public final String NAME="Currency Loader";
    Map<String, Double> loadCurrencies();
}