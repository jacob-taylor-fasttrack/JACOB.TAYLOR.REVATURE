package com.revature.repos;

import java.util.List;

import com.revature.models.Communication;

public interface CommRepo {
	public Communication addCommunication(Communication c);

	public List<Communication> getAllCommunication();

	public Communication getCommunication(int id);

	public Communication updateCommunication(Communication change);

	public Communication deleteCommunication(Communication c);
}
