package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.revature.models.Employees;
import com.revature.repos.EmployeesRepo;
import com.revature.repos.EmployeesRepoHBImpl;

public class EmployeesRepoTest {
	public static Employees e;

	@Before
	public void init() {
		e = new Employees();
		e.setFirstname("Jacob");
		e.setLastname("Taylor");
		e.setUsername("jtaylor");
		e.setPassword("password");
	}

	@Test
	public void testCreateEmployees() {
		EmployeesRepo er = new EmployeesRepoHBImpl();
		Employees test = er.addEmployee(e);
		assertNotNull(test);
		assertEquals(test.getUsername(), "jtaylor");
	}

	@Test
	public void testGetEmployees() {
		EmployeesRepo er = new EmployeesRepoHBImpl();
		Employees test = er.getEmployee(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllEmployees() {
		EmployeesRepo er = new EmployeesRepoHBImpl();
		List<Employees> tests = er.getAllEmployees();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateEmployees() {
		EmployeesRepo er = new EmployeesRepoHBImpl();
		Employees test = er.updateEmployees(e);
		assertNotNull(test);
		assertEquals(test.getUsername(), "jtaylor");
	}

	@Test
	public void testDeleteEmployees() {
		EmployeesRepo er = new EmployeesRepoHBImpl();
		Employees test = er.deleteEmployees(e);
		assertEquals(null, test);

	}
}
