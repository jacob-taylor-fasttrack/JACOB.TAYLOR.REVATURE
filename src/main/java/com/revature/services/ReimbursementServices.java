package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursements;

public interface ReimbursementServices {
	public Reimbursements addReimbursements(Reimbursements rr);

	public List<Reimbursements> getAllReimbursements();

	public Reimbursements getReimbursement(int id);

	public Reimbursements updateReimbursements(Reimbursements change);

	public Reimbursements deleteReimbursements(Reimbursements rr);

	public String disbursedondate(String dod);

}
