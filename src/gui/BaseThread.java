package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import data.CryptoPair;
import data.SelectedPairs;
import marketConstant.MarketExmo;
import marketConstant.Market;

public class BaseThread implements Runnable {
	
	public List<Market> markets = null;
	public Map<Market,List> marketsPairsNames = null;

	@Override
	public void run() {

//		getMenuPairs(); записать имена пар в меню

		writeWidget();

	}

	private void writeWidget() {

		SelectedPairs selectedPairs = null;

		MyFrame frame = new MyFrame();
		while (true) {
			selectedPairs = new SelectedPairs();
			frame.pairsInfoView(selectedPairs.getMarketsInfo());
			frame.setVisible(true);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
	}

	private void getMenuPairs() {

		markets = new ArrayList<>();
		markets.add(new MarketExmo());

		marketsPairsNames = new HashMap<Market, List>();

		List<String> pairsNames = null;
		for (Market element : markets) {
			pairsNames = new ArrayList<>();
			try {
				pairsNames = element.getMarketPairsNames();
				marketsPairsNames.put(element, pairsNames);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
