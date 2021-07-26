package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.revature.models.DeniedRequests;
import com.revature.repos.DeniedReqHBImpl;
import com.revature.repos.DeniedRequestsRepo;

public class DeniedRequestsRepoTest {
	public static DeniedRequests dr;

	@Before
	public void init() {
		dr = new DeniedRequests();
		dr.setDenier(11);
		dr.setReason("Doesnt meet qualifications");
		dr.setId(1);
	}

	@Test
	public void testCreateDeniedRequests() {
		DeniedRequestsRepo drr = new DeniedReqHBImpl();
		DeniedRequests test = drr.addDeniedRequest(dr);
		assertNotNull(test);
		assertEquals(test.getReason(), "Doesnt meet qualifications");
	}

	@Test
	public void testGetDeniedRequest() {
		DeniedRequestsRepo drr = new DeniedReqHBImpl();
		DeniedRequests test = drr.getDeniedRequest(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllDeniedRequests() {
		DeniedRequestsRepo drr = new DeniedReqHBImpl();
		List<DeniedRequests> tests = drr.getAllDeniedRequests();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateDeniedRequest() {
		DeniedRequestsRepo drr = new DeniedReqHBImpl();
		DeniedRequests test = drr.updateDeniedRequests(dr);
		assertNotNull(test);
		assertEquals(test.getReason(), "Denied");
	}

	@Test
	public void testDeleteDeniedRequest() {
		DeniedRequestsRepo drr = new DeniedReqHBImpl();
		DeniedRequests test = drr.deleteDeniedRequests(dr);
		assertEquals(null, test);

	}
}
