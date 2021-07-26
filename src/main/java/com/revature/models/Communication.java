package com.revature.models;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Communication")
public class Communication {
	@Id
	@Column(name = "communication_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date messagedate;
	private String message;
	private int requestId;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Requests_Comm", joinColumns = @JoinColumn(name = "requestId"), inverseJoinColumns = @JoinColumn(name = "rr_id"))
	private List<ReimbRequests> reimbr;
	@ManyToOne
	@JoinColumn(name = "sender")
	private Employees sender;
	@ManyToOne
	@JoinColumn(name = "recipient")
	private Employees recipient;

	public Communication() {
		super();
	}

	public Communication(int id, Employees sender, Employees recipient, Date messagedate, String message,
			int requestId) {
		super();
		this.id = id;
		this.sender = sender;
		this.recipient = recipient;
		this.messagedate = messagedate;
		this.message = message;
		this.requestId = requestId;
	}

	public Communication(Employees sender, Employees recipient, Date messagedate, String message, int requestId) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.messagedate = messagedate;
		this.message = message;
		this.requestId = requestId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employees getSender() {
		return sender;
	}

	public void setSender(Employees sender) {
		this.sender = sender;
	}

	public Employees getRecipient() {
		return recipient;
	}

	public void setRecipient(Employees recipient) {
		this.recipient = recipient;
	}

	public Date getMessagedate() {
		return messagedate;
	}

	public void setMessagedate(Date messagedate) {
		this.messagedate = messagedate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "Communication [id=" + id + ", sender=" + sender + ", recipient=" + recipient + ", messagedate="
				+ messagedate + ", message=" + message + ", requestId=" + requestId + "]";
	}

}
