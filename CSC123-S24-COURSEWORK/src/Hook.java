import java.io.InputStream;

public class Hook extends AbstractCurrencyLoader{
	
	@Override
	public InputStream getStream()
	{
		String line = "CAD,Canadian Dollar,0.60\n"
				+ "EUR,European Dollar,1.20";
		ByteArrayInputStream bi = new ByteInputStream(line.getBytes());
		return bi;;
	}
}
