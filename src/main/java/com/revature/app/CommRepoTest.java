package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.revature.models.Communication;
import com.revature.repos.CommRepo;
import com.revature.repos.CommRepoHBImpl;

public class CommRepoTest {
	public static Communication c;

	@Before
	public void init() {
		c = new Communication();

		c.setMessage("We have yet to decide our decision");
	}

	@Test
	public void testCreateCommunication() {
		CommRepo cd = new CommRepoHBImpl();
		Communication test = cd.addCommunication(c);
		assertNotNull(test);
		assertEquals(test.getMessage(), "We have yet to decide our decision");
	}

	@Test
	public void testGetCommunication() {
		CommRepo cd = new CommRepoHBImpl();
		Communication test = cd.getCommunication(10);
		assertNotNull(test);
		assertEquals(test.getId(), 10);
	}

	@Test
	public void testGetAllCommunications() {
		CommRepo cd = new CommRepoHBImpl();
		List<Communication> tests = cd.getAllCommunication();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateCommunication() {
		CommRepo cr = new CommRepoHBImpl();
		Communication test = cr.updateCommunication(c);
		assertNotNull(test);
		assertEquals(test.getMessage(), "Approved");
	}

	@Test
	public void testDeleteCommunication() {
		CommRepo cd = new CommRepoHBImpl();
		Communication test = cd.deleteCommunication(c);
		assertEquals(null, test);

	}

}
