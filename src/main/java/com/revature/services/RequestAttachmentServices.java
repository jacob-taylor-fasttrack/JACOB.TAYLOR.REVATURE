package com.revature.services;

import java.util.List;

import com.revature.models.RequestAttachments;

public interface RequestAttachmentServices {
	public RequestAttachments addRequestAttachments(RequestAttachments rar);

	public List<RequestAttachments> getAllRequestAttachments();

	public RequestAttachments getRequestAttachment(int id);

	public RequestAttachments updateRequestAttachments(RequestAttachments change);

	public RequestAttachments deleteRequestAttachments(RequestAttachments rar);

	public String addAttachFunctionality(String attachurl);
}
