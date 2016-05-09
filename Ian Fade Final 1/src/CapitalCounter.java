
public class CapitalCounter implements Runnable{

	@Override
	public void run() {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < 26; i++){
			System.out.print(letters.charAt(i) + " ");
		}
	}
}
