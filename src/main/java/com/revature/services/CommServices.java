package com.revature.services;

import java.util.List;

import com.revature.models.Communication;

public interface CommServices {
	public Communication addCommunication(Communication c);

	public List<Communication> getAllCommunication();

	public Communication getCommunication(int id);

	public Communication updateCommunication(Communication change);

	public Communication deleteCommunication(Communication c);

	public String messagedate(String messagedate);

	public Communication supervisorComm(Communication s);

	public Communication deptheadComm(Communication d);

	public Communication bencoComm(Communication b);

}
