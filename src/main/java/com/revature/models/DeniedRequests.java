package com.revature.models;

import java.util.Date;
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
@Table(name = "DeniedRequests")
public class DeniedRequests {
	@Id
	@Column(name = "deniedrequest_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "decisionmade", nullable = false)
	private Date decisionmade;
	@Column(name = "reason", nullable = false)
	private String reason;
	private int denier;
	private int requestID;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Deniedreq_reimbreq", joinColumns = @JoinColumn(name = "requestID"), inverseJoinColumns = @JoinColumn(name = "rr_id"))
	private List<ReimbRequests> reimbd;

	public DeniedRequests(int id, Date decisionmade, String reason, int denier, int requestID) {
		super();
		this.id = id;
		this.decisionmade = decisionmade;
		this.reason = reason;
		this.denier = denier;
		this.requestID = requestID;
	}

	public DeniedRequests() {
		super();
	}

	public DeniedRequests(Date decisionmade, String reason, int denier, int requestID) {
		super();
		this.decisionmade = decisionmade;
		this.reason = reason;
		this.denier = denier;
		this.requestID = requestID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDecisionmade() {
		return decisionmade;
	}

	public void setDecisionmade(Date decisionmade) {
		this.decisionmade = decisionmade;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getDenier() {
		return denier;
	}

	public void setDenier(int denier) {
		this.denier = denier;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	@Override
	public String toString() {
		return "DeniedRequests [id=" + id + ", decisionmade=" + decisionmade + ", reason=" + reason + ", denier="
				+ denier + ", requestID=" + requestID + "]";
	}

}
