package gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import data.CryptoPair;
import marketConstant.ExmoPairs;
import marketConstant.MarketPairs;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Crypto course");
		this.setBounds(620,740,350,65);
//		this.setBackground(Color.green);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setPairsOption() {
		MarketPairs marketPairs = new ExmoPairs();
		ArrayList<String> pairsArray;
		try {
			pairsArray = marketPairs.getMarketPairs();
			JPanel panel = new JPanel();
//			panel.setBackground(Color.RED);
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
//		panel.setBackground(Color.RED);
		JLabel label = new JLabel(pair.getName()+"  "+pair.getBuyPrice()+" /  "+pair.getSellPrice());
//		label.setBackground(Color.YELLOW);
		panel.add(label);
//		panel.add(new JLabel("  "+pair.getBuyPrice()));
//		panel.add(new JLabel(" /  "+pair.getSellPrice()));
//		this.setTitle(pair.getName()+"  "+pair.getBuyPrice()+" /  "+pair.getSellPrice());
//		this.setBackground(Color.YELLOW);
		
		this.getContentPane().add(panel);
	}

}
