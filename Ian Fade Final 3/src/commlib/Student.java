package commlib;
import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private long id;
	private double score;
	
	public Student(String name, long id, double score){
		this.setName(name);
		this.setId(id);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
