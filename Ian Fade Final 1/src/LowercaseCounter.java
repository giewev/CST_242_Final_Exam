
public class LowercaseCounter implements Runnable{

	@Override
	public void run() {
		String letters = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < 26; i++){
			System.out.print(letters.charAt(i) + " ");
		}
	}

}
