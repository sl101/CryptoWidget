package gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import data.CryptoPair;
import marketConstant.ExmoPairs;
import marketConstant.MarketPairs;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Crypto course");
		this.setBounds(900,50,250,80);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setPairsOption() {
		MarketPairs marketPairs = new ExmoPairs();
		ArrayList<String> pairsArray;
		try {
			pairsArray = marketPairs.getMarketPairs();
//			System.out.println(pairsArray);
			JPanel panel = new JPanel();
			for (int i = 0; i < pairsArray.size(); i++) {
				String value = pairsArray.get(i);
				panel.add(new JLabel(value));
				this.getContentPane().add(panel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void pairsInfoView(CryptoPair pair) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(pair.getName()));
		panel.add(new JLabel("  "+pair.getBuyPrice()));
		panel.add(new JLabel(" /  "+pair.getSellPrice()));
		this.getContentPane().add(panel);
	}

}
