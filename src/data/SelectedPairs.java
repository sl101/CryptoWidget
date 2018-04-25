package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gui.BaseThread;
import marketConstant.Market;
import marketConstant.MarketExmo;

public class SelectedPairs {

	Map<Market, List<CryptoPair>> marketsInfo = null;

	public SelectedPairs() {
		marketsInfo = new HashMap<>();
		selectPairs();
	}

	private void selectPairs() {

		Market market = new MarketExmo();

		// List<CryptoPair> pairs = marketsInfo must read from menu, but now ...

		List<CryptoPair> pairs = null;
		try {
			pairs = market.getMarketPairs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		marketsInfo.put(market, pairs);

	}

	public Map<Market, List<CryptoPair>> getMarketsInfo() {
		return marketsInfo;
	}

	public void setMarketsInfo(Map<Market, List<CryptoPair>> marketsInfo) {
		this.marketsInfo = marketsInfo;
	}

}
