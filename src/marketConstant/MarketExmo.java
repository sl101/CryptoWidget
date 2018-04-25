package marketConstant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.CryptoPair;

public class MarketExmo implements Market {

	private final static String url = "https://exmo.me/uk/trade#?";
	private static List<String> marketPairsNames = null;

	public MarketExmo() {
		marketPairsNames = new ArrayList<>();
		getPairsNames();
	}

	private void getPairsNames() {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements = doc.body().getElementsByAttributeValue("class", "table_body pair");
		for (Element element : elements) {
			String pairName = element.getElementsByAttributeValue("class", "scol_2").text();
			marketPairsNames.add(pairName);
		}
	}

	@Override
	public ArrayList<CryptoPair> getMarketPairs() throws IOException {
		List<CryptoPair> marketPairs = new ArrayList();
		CryptoPair cryptoPair = null;
		Document doc = Jsoup.connect(url).get();
//		for (String element : marketPairsNames) {
//			String pair = element.replace("/", "_");
//			cryptoPair.setName(pair);
			Elements elements = doc.body().getElementsByAttributeValue("class", "table_body pair");
			for (Element element : elements) {
				cryptoPair = new CryptoPair();
				String pairName = element.getElementsByAttributeValue("class", "scol_2").text();
				cryptoPair.setName(pairName);
				String buyPrice = element.getElementsByAttributeValue("class", "scol_3 buy_price").text();
				cryptoPair.setBuyPrice(Double.parseDouble(buyPrice));
				String sellPrice = element.getElementsByAttributeValue("class", "scol_4 sell_price").text();
				cryptoPair.setSellPrice(Double.parseDouble(sellPrice));
				marketPairs.add(cryptoPair);
			}
//		}
//		for (CryptoPair crypto : marketPairs) {
//			System.out.println(crypto.getName() + " " + crypto.getBuyPrice() + " " + crypto.getSellPrice());
//		}
		return (ArrayList<CryptoPair>) marketPairs;
	}

	@Override
	public ArrayList<String> getMarketPairsNames() {
		// getPairsNames();
		return (ArrayList<String>) marketPairsNames;
	}

	@Override
	public String getUrl() {
		return url;
	}

}
