
public class CapitalCounter implements Runnable{
	private SynchronizedArrayList<String> target;
	
	public CapitalCounter(SynchronizedArrayList<String> target){
		this.target = target;
	}
	
	
	@Override
	public void run() {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < 26; i++){
			this.target.add(String.valueOf(letters.charAt(i)));
		}
	}
	

}
