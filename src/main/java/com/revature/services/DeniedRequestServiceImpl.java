package com.revature.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.revature.models.Communication;
import com.revature.models.DeniedRequests;
import com.revature.repos.DeniedRequestsRepo;

public class DeniedRequestServiceImpl implements DeniedRequestsServices {
	public DeniedRequestsRepo drr;

	public DeniedRequestServiceImpl(DeniedRequestsRepo drr) {
		this.drr = drr;
	}

	public DeniedRequestServiceImpl() {
		super();
	}

	@Override
	public DeniedRequests addDeniedRequest(DeniedRequests dr) {
		return drr.addDeniedRequest(dr);
	}

	@Override
	public List<DeniedRequests> getAllDeniedRequests() {
		return drr.getAllDeniedRequests();
	}

	@Override
	public DeniedRequests getDeniedRequest(int id) {
		return drr.getDeniedRequest(id);
	}

	@Override
	public DeniedRequests updateDeniedRequests(DeniedRequests change) {
		return drr.updateDeniedRequests(change);
	}

	@Override
	public DeniedRequests deleteDeniedRequests(DeniedRequests dr) {
		return drr.deleteDeniedRequests(dr);
	}

	@Override

	public String getDecisionDate(String dr) {
		DeniedRequests de = new DeniedRequests();
		dr = drr.getDeniedRequest(de.getId()).toString();

		Date messagedate = de.getDecisionmade();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(messagedate);
	}

}
