package data;

import java.util.List;

public class CryptoPair {
	
	private String name;
	private double sellPrice;
	private double buyPrice;
//	private List<CryptoPair> pairs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
//	public List<CryptoPair> getPairs() {
//		return pairs;
//	}
//	public void setPairs(List<CryptoPair> pairs) {
//		this.pairs = pairs;
//	}
	

	
}
