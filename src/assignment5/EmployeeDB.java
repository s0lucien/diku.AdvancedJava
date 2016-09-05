package assignment5;

import java.util.List;

import assignment5.AccessException;
import assignment5.DepartmentNotFoundException;
import assignment5.Employee;
import assignment5.NegativeSalaryIncrementException;
import assignment5.SalaryIncrement;

/**
 * EmployeeDB declares the methods that can be invoked to interact with the
 * employee database server
 * 
 * @author bonii
 * 
 */
public interface EmployeeDB {

	/**
	 * Add an employee in the employee database
	 * 
	 * @param emp Represents an employee
	 */
	public void addEmployee(Employee emp) throws DepartmentNotFoundException, AccessException;

	/**
	 * List all the employees in a department
	 */
	public List<Employee> listEmployeesInDept(List<Integer> departmentIds)
			throws DepartmentNotFoundException, AccessException;

	/**
	 * Increments salaries of all employees in the department. Ensure salaries
	 * of all employees are incremented or for none of them are incremented,
	 * errors through appropriate Exception
	 * 
	 * @param salaryIncrements
	 *            Represents the salary increment for a department
	 */
	public void incrementSalaryOfDepartment(List<SalaryIncrement> salaryIncrement)
			throws DepartmentNotFoundException, NegativeSalaryIncrementException, AccessException;

	/**
	 * Cleans up the employee database to an empty state
	 */
	public void cleanupDB() throws AccessException;
}
