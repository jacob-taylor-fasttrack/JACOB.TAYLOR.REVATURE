package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.revature.models.ReimbRequests;
import com.revature.repos.ReimbRequestsRepo;
import com.revature.repos.ReimbRequestsRepoHBImpl;

public class ReimbRequestRepoTest {
	public static ReimbRequests rr;

	@Before
	public void init() {
		rr.setAmount(200);
		rr.setDecision("Approved");
		rr.setJustification("For improving python knowledge");
		rr.setLastupdated(null);
		rr.setPendingresponsefrom("Supervisor");
		rr.setProposedamount(300);
		rr.setTimerequired(2);
		rr.setUrgent(false);
		rr.setId(1);
	}

	@Test
	public void testCreateReimbRequests() {
		ReimbRequestsRepo rrr = new ReimbRequestsRepoHBImpl();
		ReimbRequests test = rrr.addReimbRequests(rr);
		assertNotNull(test);
		assertEquals(test.isUrgent(), true);
	}

	@Test
	public void testGetReimbRequests() {
		ReimbRequestsRepo rrr = new ReimbRequestsRepoHBImpl();
		ReimbRequests test = rrr.getReimbRequest(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllReimbRequests() {
		ReimbRequestsRepo rrr = new ReimbRequestsRepoHBImpl();
		List<ReimbRequests> tests = rrr.getAllReimbRequests();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateReimbRequests() {
		ReimbRequestsRepo rrr = new ReimbRequestsRepoHBImpl();
		ReimbRequests test = rrr.updateReimbRequests(rr);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testDeleteReimbRequests() {
		ReimbRequestsRepo rrr = new ReimbRequestsRepoHBImpl();
		ReimbRequests test = rrr.deleteReimbRequests(rr);
		assertEquals(null, test);

	}
}
