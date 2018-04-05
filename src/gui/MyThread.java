package gui;

import java.io.IOException;

import data.CryptoInfo;
import data.CryptoPair;

public class MyThread implements Runnable {

	@Override
	public void run() {
		MyFrame frame = new MyFrame();
		while(true){
			CryptoPair pair;
			try {
				pair = new CryptoInfo().getPairInfo("BTC_USD");
//				получить информацию о выбранной паре / парах (chekedPairs)
//				pair = new CryptoInfo().getPairInfo(chekedPairs);
				frame.pairsInfoView(pair);
				frame.setVisible(true);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
