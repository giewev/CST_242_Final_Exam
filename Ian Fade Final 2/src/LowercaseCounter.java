
public class LowercaseCounter implements Runnable{
	private SynchronizedArrayList<String> target;
	
	public LowercaseCounter(SynchronizedArrayList<String> target){
		this.target = target;
	}
	
	@Override
	public void run() {
		String letters = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < 26; i++){
			this.target.add(String.valueOf(letters.charAt(i)));
		}
	}

}
