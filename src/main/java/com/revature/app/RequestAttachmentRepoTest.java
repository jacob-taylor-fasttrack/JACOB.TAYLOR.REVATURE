package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.revature.models.RequestAttachments;
import com.revature.repos.RequestAttachmentsRepo;
import com.revature.repos.RequestAttachmentsRepoHBImpl;

public class RequestAttachmentRepoTest {
	public static RequestAttachments ra;

	@Before
	public void init() {
		ra.setDocurl(null);
		ra.setIsapproved(true);
		ra.setIsgrade(true);
		ra.setId(1);
	}

	@Test
	public void testCreateRequestAttachments() {
		RequestAttachmentsRepo rar = new RequestAttachmentsRepoHBImpl();
		RequestAttachments test = rar.addRequestAttachments(ra);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetRequestAttachments() {
		RequestAttachmentsRepo rar = new RequestAttachmentsRepoHBImpl();
		RequestAttachments test = rar.getRequestAttachment(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllRequestAttachments() {
		RequestAttachmentsRepo rar = new RequestAttachmentsRepoHBImpl();
		List<RequestAttachments> tests = rar.getAllRequestAttachments();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateRequestAttachments() {
		RequestAttachmentsRepo rar = new RequestAttachmentsRepoHBImpl();
		RequestAttachments test = rar.updateRequestAttachments(ra);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testDeleteRequestAttachments() {
		RequestAttachmentsRepo rar = new RequestAttachmentsRepoHBImpl();
		RequestAttachments test = rar.deleteRequestAttachments(ra);
		assertEquals(null, test);

	}
}
