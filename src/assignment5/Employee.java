package assignment5;

/**
 * Employee represents an employee record
 * 
 * @author bonii
 *
 */
public class Employee {

	private int id;
	private String name;
	private int department;
	private float salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object o) {
		// avoiding ClassCastException by explicit check
		// instanceof also returns false if "o" is null
		if (!(o instanceof Employee)) {
			return false;
		}
		return (this.getId() == ((Employee) o).getId());
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}
