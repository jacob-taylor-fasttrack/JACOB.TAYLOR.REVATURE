package com.revature.bankingapiAPP;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.bankingapiMODELS.Client;
import com.revature.bankingapiREPOS.ClientDAO;
import com.revature.bankingapiREPOS.ClientDAODBimpl;

class ClientDAOImplTest {
	public static Client c;

	@Before
	public void init() {
		c = new Client();
		c.setFirstName("Jacob");
		c.setLastName("Taylor");
		c.setEmail("jt@yahoo.com");
		c.setPassword("jacob");
	}

	@Test
	public void testCreateClient() {
		ClientDAO cd = new ClientDAODBimpl();
		Client test = cd.createClient(c);
		assertNotNull(test);
		assertEquals(test.getFirstName(), "Jacob");
	}

	@Test
	public void testGetClient() {
		ClientDAO cd = new ClientDAODBimpl();
		Client test = cd.getClient(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllClients() {
		ClientDAO cd = new ClientDAODBimpl();
		List<Client> tests = cd.getAllClients();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateClient() {
		ClientDAO cd = new ClientDAODBimpl();
		Client test = cd.updateClient(c);
		assertNotNull(test);
		assertEquals(test.getFirstName(), "Jacob");
	}

	@Test
	public void testDeleteClient() {
		ClientDAO cd = new ClientDAODBimpl();
		Client test = cd.deleteClient(1);
		assertEquals(null, test);

	}
}
