package com.revature.bankingapiSERVICES;

import java.util.ArrayList;
import java.util.List;

import com.revature.bankingapiMODELS.Client;
import com.revature.bankingapiREPOS.ClientDAO;

public class ClientServiceImpl implements ClientService {

	public ClientDAO cd;

	public ClientServiceImpl(ClientDAO cd) {
		this.cd = cd;
	}

	@Override
	public Client createClient(Client c) {
		return cd.createClient(c);
	}

	@Override
	public Client getClient(int id) {
		return cd.getClient(id);
	}

	@Override
	public List<Client> getAllClients() {
		return cd.getAllClients();
	}

	@Override
	public Client updateClient(Client change) {
		return cd.updateClient(change);
	}

	@Override
	public Client deleteClient(int id) {
		return cd.deleteClient(id);
	}

	@Override
	public List<Client> getClientsWithCheckingAccounts(boolean checkingAccounts) {

		// List<Client> clients = cd.getAllClients();
		List<Client> refinedClients = new ArrayList<Client>();

		return refinedClients;
	}

	@Override
	public Client forgotPassword() {
		return null;
	}
}
