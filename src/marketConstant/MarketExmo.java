package marketConstant;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.CryptoExchangeMarkets;

public class ExmoPairs implements MarketPairs{

	@Override
	public ArrayList<String> getMarketPairs() throws IOException {
		String url = new CryptoExchangeMarkets().EXMO;
		ArrayList<String> result = new ArrayList<>();
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.body().getElementsByAttributeValue("class", "table_body pair");
		
		for(Element element : elements){
			int criptLength = element.getElementsByAttributeValue("class", "scol_2").toString().length();
			result.add(element.getElementsByAttributeValue("class", "scol_2").toString().substring(19, criptLength-5).toString());
		        }
		return result;
	}

}
