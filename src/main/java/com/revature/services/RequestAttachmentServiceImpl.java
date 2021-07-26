package com.revature.services;

import java.util.List;

import javax.xml.bind.attachment.AttachmentMarshaller;

import com.revature.models.RequestAttachments;
import com.revature.repos.RequestAttachmentsRepo;

public class RequestAttachmentServiceImpl implements RequestAttachmentServices {
	public RequestAttachmentsRepo rar;

	public RequestAttachmentServiceImpl(RequestAttachmentsRepo rar) {
		this.rar = rar;
	}

	public RequestAttachmentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RequestAttachments addRequestAttachments(RequestAttachments ra) {
		return rar.addRequestAttachments(ra);
	}

	@Override
	public List<RequestAttachments> getAllRequestAttachments() {
		return rar.getAllRequestAttachments();
	}

	@Override
	public RequestAttachments getRequestAttachment(int id) {
		return rar.getRequestAttachment(id);
	}

	@Override
	public RequestAttachments updateRequestAttachments(RequestAttachments change) {
		return rar.updateRequestAttachments(change);
	}

	@Override
	public RequestAttachments deleteRequestAttachments(RequestAttachments ra) {
		return rar.deleteRequestAttachments(ra);
	}

	@Override
	public String addAttachFunctionality(String docurl) {
		RequestAttachments url = new RequestAttachments();
		return url.getDocurl();
	}

}
