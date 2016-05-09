package commlib;

import java.io.Serializable;

public class Update implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long count;
	private double average;
	
	public Update(long count, double average){
		this.setCount(count);
		this.setAverage(average);
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
}
