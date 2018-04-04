package data;
import java.util.ArrayList;

public class SelectPairs {

	private ArrayList<CryptoPair> pairs = null;
	
	public SelectPairs(){
		pairs = new ArrayList<>();
	}

	public ArrayList<CryptoPair> getPairs() {
		return pairs;
	}

	public void setPairs(ArrayList<CryptoPair> pairs) {
		this.pairs = pairs;
	}
	

	
}
