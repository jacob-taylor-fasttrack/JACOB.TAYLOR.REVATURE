package com.revature.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.revature.models.Communication;
import com.revature.models.EventTypes;
import com.revature.models.Reimbursements;
import com.revature.repos.ReimbursementsRepo;

import jdk.jfr.EventType;

public class ReimbursementServicesImpl implements ReimbursementServices {
	public ReimbursementsRepo rr;

	public ReimbursementServicesImpl(ReimbursementsRepo rr) {
		this.rr = rr;
	}

	public ReimbursementServicesImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Reimbursements addReimbursements(Reimbursements r) {
		return rr.addReimbursements(r);
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {
		return rr.getAllReimbursements();
	}

	@Override
	public Reimbursements getReimbursement(int id) {
		return rr.getReimbursement(id);
	}

	@Override
	public Reimbursements updateReimbursements(Reimbursements change) {
		return rr.updateReimbursements(change);
	}

	@Override
	public Reimbursements deleteReimbursements(Reimbursements r) {
		return rr.deleteReimbursements(r);
	}

	@Override
	public String disbursedondate(String dod) {
		Reimbursements re = new Reimbursements();
		dod = rr.getReimbursement(re.getId()).toString();
		Date disbursedon = re.getDisbursedon();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(disbursedon);

	}

}
