
public class NumberCounter implements Runnable{
	private SynchronizedArrayList<String> target;
	
	public NumberCounter(SynchronizedArrayList<String> target){
		this.target = target;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 26; i++){
			this.target.add(String.valueOf(i));
		}
	}
	
}
