
public class NumberCounter implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i <= 26; i++){
			System.out.print(i + " ");
		}
	}
	
}
