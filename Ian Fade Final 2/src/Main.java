import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {
	public static void main(String[] args) {
		BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<Runnable>(3);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 4, 30, TimeUnit.SECONDS, tasks);
		
		SynchronizedArrayList<String> target = new SynchronizedArrayList<String>();
		pool.execute(new NumberCounter(target));
		pool.execute(new CapitalCounter(target));
		pool.execute(new LowercaseCounter(target));
		
		System.out.println(target);
	}
}
