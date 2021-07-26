package com.revature.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.revature.models.ReimbRequests;
import com.revature.repos.ReimbRequestsRepo;

public class ReimbRequestServiceImpl implements ReimbRequestServices {
	public ReimbRequestsRepo rrr;

	public ReimbRequestServiceImpl(ReimbRequestsRepo rrr) {
		this.rrr = rrr;
	}

	public ReimbRequestServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ReimbRequests addReimbRequests(ReimbRequests rr) {
		return rrr.addReimbRequests(rr);
	}

	@Override
	public List<ReimbRequests> getAllReimbRequests() {
		return rrr.getAllReimbRequests();
	}

	@Override
	public ReimbRequests getReimbRequest(int id) {
		return rrr.getReimbRequest(id);
	}

	@Override
	public ReimbRequests updateReimbRequests(ReimbRequests change) {
		return rrr.updateReimbRequests(change);
	}

	@Override
	public ReimbRequests deleteReimbRequests(ReimbRequests rr) {
		return rrr.deleteReimbRequests(rr);
	}

	@Override
	public String lastUpdated(String ud) {
		ReimbRequests reimb = new ReimbRequests();
		ud = rrr.getReimbRequest(reimb.getId()).toString();
		Date lastupdate = reimb.getLastupdated();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(lastupdate);

	}

	@Override
	public ReimbRequests urgentReimbRequests(int u) {
		ReimbRequests ur = new ReimbRequests();
		ReimbRequests urgent = rrr.getReimbRequest(ur.getId());
		ur.setUrgent(false);
		if (ur.isUrgent() == true) {

			urgent.setDecision("Approved");
			return urgent;
		}
		return ur;
	}

	@Override

	public double proposedAmount(double pa) {
		ReimbRequests rer = new ReimbRequests();
		rer = rrr.getReimbRequest(rer.getId());
		double proposedamount = rer.getProposedamount();
		double awarded = rer.getAmount();
		double Available = 1000 - awarded;
		double a = Available - proposedamount;
		return a;
	}

}
