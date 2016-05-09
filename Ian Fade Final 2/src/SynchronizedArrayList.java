import java.util.ArrayList;


public class SynchronizedArrayList<T> extends ArrayList<T> {
	private static final long serialVersionUID = 1L;
	
	@Override
	public synchronized boolean add(T newT){
		return super.add(newT);
	}
}
