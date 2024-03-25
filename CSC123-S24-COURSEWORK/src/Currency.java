
public class Currency {

	String currencyCode;
	String currencyDescription;
	double exchangeRate;
	
	public Currency(String currencyCode, String currencyDescription, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.currencyDescription = currencyDescription;
        this.exchangeRate = exchangeRate;
	}
	
	public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyDescription() {
        return currencyDescription;
    }

    public void setCurrencyDescription(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
