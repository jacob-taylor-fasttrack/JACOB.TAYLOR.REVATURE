package com.revature.repos;

import java.util.List;

import com.revature.models.RequestAttachments;

public interface RequestAttachmentsRepo {
	public RequestAttachments addRequestAttachments(RequestAttachments rar);

	public List<RequestAttachments> getAllRequestAttachments();

	public RequestAttachments getRequestAttachment(int id);

	public RequestAttachments updateRequestAttachments(RequestAttachments change);

	public RequestAttachments deleteRequestAttachments(RequestAttachments rar);
}
