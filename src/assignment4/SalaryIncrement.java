package assignment4;

/**
 * SalaryIncrement represents a record by which a department's salary will be
 * adjusted
 * 
 * @author bonii
 * 
 */
public class SalaryIncrement {

	private int department;
	private float incrementBy;

	public SalaryIncrement(int department, float incrementBy) {
		this.department = department;
		this.incrementBy = incrementBy;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public float getIncrementBy() {
		return incrementBy;
	}

	public void setIncrementBy(float incrementBy) {
		this.incrementBy = incrementBy;
	}

}
