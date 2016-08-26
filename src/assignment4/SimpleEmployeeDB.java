package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleEmployeeDB implements EmployeeDB {

	private List<Employee> employees;
	private List<Integer> departmentIds;

	public SimpleEmployeeDB(List<Integer> departmentIds) {
		employees = new ArrayList<>();
		this.departmentIds = departmentIds;
	}

	@Override
	public synchronized void addEmployee(Employee emp) throws DepartmentNotFoundException {
		if (departmentIds.contains(emp.getDepartment())) {
			if (notExisting(emp))
				employees.add(emp);
		} else {
			throw new DepartmentNotFoundException("The provided employee is from an unsupported department");
		}
	}

	private boolean notExisting(Employee emp) {
		for (Employee e: employees)
			if (e.getId() == emp.getId())
				return false;
		return true;
	}

	@Override
	public List<Employee> listEmployeesInDept(List<Integer> departmentIds) throws DepartmentNotFoundException {
		List<Employee> result = new ArrayList<>();
		if (Collections.indexOfSubList(this.departmentIds, departmentIds) != -1) {
			for (Employee e: employees) {
				if (departmentIds.contains(e.getDepartment()))
					result.add(e);
			}
		} else
			throw new DepartmentNotFoundException("The provided departmentId is not supported on this server");
		return result;
	}

	@Override
	public synchronized void cleanupDB() {
		employees = new ArrayList<>();
	}

	@Override
	public synchronized void incrementSalaryOfDepartment(List<SalaryIncrement> salaryIncrements) throws DepartmentNotFoundException,
			NegativeSalaryIncrementException {
		checkSalaryIncrementValidity(salaryIncrements);
		for (SalaryIncrement si: salaryIncrements) {
			for (Employee e: employees) {
				if (si.getDepartment() == e.getDepartment())
					e.setSalary(e.getSalary() + si.getIncrementBy());
			}
		}

	}

	private void checkSalaryIncrementValidity(List<SalaryIncrement> salaryIncrements) throws DepartmentNotFoundException, NegativeSalaryIncrementException {
		for (SalaryIncrement si: salaryIncrements) {
			if (!this.departmentIds.contains(si.getDepartment()))
				throw new DepartmentNotFoundException();
			if (si.getIncrementBy() < 0)
				throw new NegativeSalaryIncrementException();
		}
	}

}
