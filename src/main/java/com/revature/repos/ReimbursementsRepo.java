package com.revature.repos;

import java.util.List;

import com.revature.models.Reimbursements;

public interface ReimbursementsRepo {
	public Reimbursements addReimbursements(Reimbursements rr);

	public List<Reimbursements> getAllReimbursements();

	public Reimbursements getReimbursement(int id);

	public Reimbursements updateReimbursements(Reimbursements change);

	public Reimbursements deleteReimbursements(Reimbursements rr);
}
