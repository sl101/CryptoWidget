package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;

import data.CryptoPair;
import marketConstant.MarketExmo;
import marketConstant.Market;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Crypto course");
		this.setBounds(900, 200, 270, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void pairsInfoView(Map<Market, List<CryptoPair>> marketsInfo) {
		JPanel panel = new JPanel();

		for (Map.Entry market : marketsInfo.entrySet()) {
//			System.out.println("read marketsInfo:\n");
			List<CryptoPair> pairs = new ArrayList<>();
			pairs = (List<CryptoPair>) market.getValue();
			for (CryptoPair pair : pairs) {
				System.out.println(pair.getName() + "  " + pair.getBuyPrice() + " /  " + pair.getSellPrice());
				panel.add(new JLabel(pair.getName() + "  " + pair.getBuyPrice() + " /  " + pair.getSellPrice()));
//				panel.setAutoscrolls(true);
			}
		}

		this.getContentPane().add(panel);
	}

}
