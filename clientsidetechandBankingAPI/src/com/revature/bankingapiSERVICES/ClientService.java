package com.revature.bankingapiSERVICES;

import java.util.List;

import com.revature.bankingapiMODELS.Client;

public interface ClientService {

	public Client createClient(Client c);

	public Client getClient(int id);

	public List<Client> getAllClients();

	public Client updateClient(Client change);

	public Client deleteClient(int id);

	public List<Client> getClientsWithCheckingAccounts(boolean checkingAccounts);

	public Client forgotPassword();

}
