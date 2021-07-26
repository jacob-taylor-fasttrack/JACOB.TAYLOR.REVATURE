package com.revature.repos;

import java.util.List;

import com.revature.models.ReimbRequests;

public interface ReimbRequestsRepo {
	public ReimbRequests addReimbRequests(ReimbRequests rrr);

	public List<ReimbRequests> getAllReimbRequests();

	public ReimbRequests getReimbRequest(int id);

	public ReimbRequests updateReimbRequests(ReimbRequests change);

	public ReimbRequests deleteReimbRequests(ReimbRequests rrr);
}
