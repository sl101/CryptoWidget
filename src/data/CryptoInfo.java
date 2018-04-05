package data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CryptoInfo {
	
	private SelectPairs selectedPairs;
	private static String url ="https://exmo.me/uk/trade#?";
	
	
	
	public CryptoPair getPairInfo(String pair){
		CryptoPair cryptoPair = new CryptoPair();
		cryptoPair.setName(pair);
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No connect");
		}
		Elements elements = doc.body().getElementsByAttributeValue("pair", pair);
		
		for(Element element : elements){
//			System.out.println(""+element.getClass());
			int buyPriceLength = element.getElementsByAttributeValue("class", "scol_3 buy_price").toString().length();
//			System.out.println(buyPriceLength);
			String buyPrice = element.getElementsByAttributeValue("class", "scol_3 buy_price").toString();
			cryptoPair.setBuyPrice(Double.parseDouble(buyPrice.substring(29, buyPriceLength-5)));
			int sellPriceLength = element.getElementsByAttributeValue("class", "scol_4 sell_price").toString().length();
			String sellPrice = element.getElementsByAttributeValue("class", "scol_4 sell_price").toString();
			cryptoPair.setSellPrice(Double.parseDouble(sellPrice.substring(30, sellPriceLength-5)));
	      }
		return cryptoPair;		
	}

	
	
}
