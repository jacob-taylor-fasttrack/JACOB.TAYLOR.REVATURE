package com.revature.repos;

import java.util.List;

import com.revature.models.Employees;

public interface EmployeesRepo {
	public Employees addEmployee(Employees e);

	public List<Employees> getAllEmployees();

	public Employees getEmployee(int id);

	public Employees updateEmployees(Employees change);

	public Employees deleteEmployees(Employees e);
}
