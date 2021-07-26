package com.revature.services;

import java.util.List;

import com.revature.models.Employees;
import com.revature.repos.EmployeesRepo;

public class EmployeeServicesImpl implements EmployeesServices {
	public EmployeesRepo er;

	public EmployeeServicesImpl(EmployeesRepo er) {
		this.er = er;
	}

	public EmployeeServicesImpl() {
		super();
	}

	@Override
	public Employees addEmployee(Employees e) {
		return er.addEmployee(e);
	}

	@Override
	public List<Employees> getAllEmployees() {
		return er.getAllEmployees();
	}

	@Override
	public Employees getEmployee(int id) {
		return er.getEmployee(id);
	}

	@Override
	public Employees updateEmployees(Employees change) {
		return er.updateEmployees(change);
	}

	@Override
	public Employees deleteEmployees(Employees e) {
		return er.deleteEmployees(e);
	}

}
