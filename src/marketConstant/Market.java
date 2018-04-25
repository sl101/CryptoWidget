package marketConstant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Market<T> {

	public ArrayList<T> getMarketPairs() throws IOException;

	public ArrayList<String> getMarketPairsNames() throws IOException;

	public String getUrl();
}
