package com.revature.bankingapiREPOS;

import java.util.List;

import com.revature.bankingapiMODELS.Client;

public interface ClientDAO {
	public Client createClient(Client c);

	public Client getClient(int id);

	public List<Client> getAllClients();

	public Client updateClient(Client change);

	public Client deleteClient(int id);

}
