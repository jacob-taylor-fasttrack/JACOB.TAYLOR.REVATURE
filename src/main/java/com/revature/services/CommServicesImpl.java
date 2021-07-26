package com.revature.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.revature.models.Communication;
import com.revature.models.Employees;
import com.revature.repos.CommRepo;

public class CommServicesImpl implements CommServices {
	public CommRepo cr;

	public CommServicesImpl(CommRepo cr) {
		this.cr = cr;
	}

	public CommServicesImpl() {
		super();
	}

	@Override
	public Communication addCommunication(Communication c) {
		return cr.addCommunication(c);
	}

	@Override
	public List<Communication> getAllCommunication() {
		return cr.getAllCommunication();
	}

	@Override
	public Communication getCommunication(int id) {
		return cr.getCommunication(id);
	}

	@Override
	public Communication updateCommunication(Communication change) {
		return cr.updateCommunication(change);
	}

	@Override
	public Communication deleteCommunication(Communication c) {
		return cr.deleteCommunication(c);
	}

	@Override
	public String messagedate(String c) {
		Communication co = new Communication();
		c = cr.getCommunication(co.getId()).toString();
		Date messagedate = co.getMessagedate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(messagedate);
	}

	@Override
	public Communication supervisorComm(Communication s) {
		ReimbRequestServices rs = new ReimbRequestServiceImpl();
		int employee_id = rs.getReimbRequest(s.getRequestId()).getEmployee();
		EmployeeServicesImpl esi = new EmployeeServicesImpl();
		s.setSender(esi.getEmployee(employee_id).getSupervisor());
		return s;
	}

	@Override
	public Communication deptheadComm(Communication d) {
		// Take the communication object 'd''s Request ID to populate the associated
		// Request form
		// retrieve the associated Employee ID attached to the Request form.
		ReimbRequestServices rs = new ReimbRequestServiceImpl();
		int employee_id = rs.getReimbRequest(d.getRequestId()).getEmployee();
		EmployeeServicesImpl esi = new EmployeeServicesImpl();
		d.setSender(esi.getEmployee(employee_id));
		return d;
	}

	@Override
	public Communication bencoComm(Communication b) {
		// TODO Auto-generated method stub
		return null;
	}

}
