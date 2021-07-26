package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RequestAttachments")
public class RequestAttachments {
	@Id
	@Column(name = "requestattachment_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "docurl")
	private String docurl;
	private int requestid;
	@Column(name = "isapproved")
	private boolean isapproved;
	@Column(name = "isgrade")
	private boolean isgrade;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Reimbursement_attachments", joinColumns = @JoinColumn(name = "requestid"), inverseJoinColumns = @JoinColumn(name = "rr_id"))
	private List<ReimbRequests> reimbursementreq;

	public RequestAttachments(int id, String docurl, int requestid, boolean isapproved, boolean isgrade) {
		super();
		this.id = id;
		this.docurl = docurl;
		this.requestid = requestid;
		this.isapproved = isapproved;
		this.isgrade = isgrade;
	}

	public RequestAttachments() {
		super();
	}

	public RequestAttachments(String docurl, int requestid, boolean isapproved, boolean isgrade) {
		super();
		this.docurl = docurl;
		this.requestid = requestid;
		this.isapproved = isapproved;
		this.isgrade = isgrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocurl() {
		return docurl;
	}

	public void setDocurl(String docurl) {
		this.docurl = docurl;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public boolean isIsapproved() {
		return isapproved;
	}

	public void setIsapproved(boolean isapproved) {
		this.isapproved = isapproved;
	}

	public boolean isIsgrade() {
		return isgrade;
	}

	public void setIsgrade(boolean isgrade) {
		this.isgrade = isgrade;
	}

	@Override
	public String toString() {
		return "RequestAttachments [id=" + id + ", docurl=" + docurl + ", requestid=" + requestid + ", isapproved="
				+ isapproved + ", isgrade=" + isgrade + "]";
	}

}
