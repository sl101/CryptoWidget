import gui.MyThread;

public class Main {

	public static void main(String[] args) {
		
		new Thread(new MyThread()).start();
		
	}
}
