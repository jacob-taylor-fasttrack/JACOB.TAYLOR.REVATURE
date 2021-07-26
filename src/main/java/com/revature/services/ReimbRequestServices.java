package com.revature.services;

import java.util.List;

import com.revature.models.ReimbRequests;

import io.javalin.http.Handler;

public interface ReimbRequestServices {
	public ReimbRequests addReimbRequests(ReimbRequests rrr);

	public List<ReimbRequests> getAllReimbRequests();

	public ReimbRequests getReimbRequest(int id);

	public ReimbRequests updateReimbRequests(ReimbRequests change);

	public ReimbRequests deleteReimbRequests(ReimbRequests rrr);

	public String lastUpdated(String ud);

	public ReimbRequests urgentReimbRequests(int urgent);

	public double proposedAmount(double proposedamount);

}
