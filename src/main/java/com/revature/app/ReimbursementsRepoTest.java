package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.revature.models.Reimbursements;
import com.revature.repos.ReimbursementsRepo;
import com.revature.repos.ReimbursementsRepoHBImpl;

public class ReimbursementsRepoTest {
	public static Reimbursements r;

	@Before
	public void init() {
		r.setDisbursedon(null);
		r.setFinalamount(200);
		r.setId(1);
	}

	@Test
	public void testCreateReimbursements() {
		ReimbursementsRepo rr = new ReimbursementsRepoHBImpl();
		Reimbursements test = rr.addReimbursements(r);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetReimbursements() {
		ReimbursementsRepo rr = new ReimbursementsRepoHBImpl();
		Reimbursements test = rr.getReimbursement(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllReimbursements() {
		ReimbursementsRepo rr = new ReimbursementsRepoHBImpl();
		;
		List<Reimbursements> tests = rr.getAllReimbursements();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateReimbursements() {
		ReimbursementsRepo rr = new ReimbursementsRepoHBImpl();
		Reimbursements test = rr.updateReimbursements(r);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testDeleteReimbursements() {
		ReimbursementsRepo rr = new ReimbursementsRepoHBImpl();
		Reimbursements test = rr.deleteReimbursements(r);
		assertEquals(null, test);

	}
}
