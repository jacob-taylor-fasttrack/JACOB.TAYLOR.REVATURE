package com.revature.bankingapiAPP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.bankingapiMODELS.Client;
import com.revature.bankingapiREPOS.ClientDAO;
import com.revature.bankingapiREPOS.ClientDAODBimpl;
import com.revature.bankingapiSERVICES.ClientService;
import com.revature.bankingapiSERVICES.ClientServiceImpl;

public class ClientServiceTest {

	Client c;

	@Before
	public void init() {
		c = new Client();
		c.setFirstName("Jacob");
		c.setEmail("jt@icloud.com");
		c.setPassword("jacob");
	}

	@Test
	public void testCreateClient() {
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.createClient(c);
		assertNotNull(test);
		assertEquals(test.getFirstName(), "Jacob");
	}

	@Test
	public void testGetClient() {
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.getClient(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllClients() {
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cr = new ClientServiceImpl(cd);
		List<Client> test = cr.getAllClients();
		assertNotNull(test);
	}

	@Test
	public void testUpdateClient() {
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.updateClient(c);
		assertEquals(test.getFirstName(), "Jacob");
	}

	@Test
	public void TestDeleteClient() {
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.deleteClient(1);
		assertEquals(null, test);
	}

	@Test
	public void testGetClientsWithCheckingAccounts() {
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cr = new ClientServiceImpl(cd);
		;
		Client test = cr.getClient(1);
		assertNotNull(test);
		assertEquals(test.getFirstName(), 1);
	}

	@Test
	public void testForgotPassword() {
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.getClient(1);
		assertNotNull(test);
		assertEquals(test.getFirstName(), 1);
	}

}
