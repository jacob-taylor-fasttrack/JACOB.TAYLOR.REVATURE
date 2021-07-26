package com.revature.repos;

import java.util.List;

import com.revature.models.DeniedRequests;

public interface DeniedRequestsRepo {
	public DeniedRequests addDeniedRequest(DeniedRequests dr);

	public List<DeniedRequests> getAllDeniedRequests();

	public DeniedRequests getDeniedRequest(int id);

	public DeniedRequests updateDeniedRequests(DeniedRequests change);

	public DeniedRequests deleteDeniedRequests(DeniedRequests dr);
}
