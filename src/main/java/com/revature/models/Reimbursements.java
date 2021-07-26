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
@Table(name = "Reimbursements")
public class Reimbursements {
	@Id
	@Column(name = "reimbursements_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "disbursedon", nullable = false)
	private Date disbursedon;
	@Column(name = "finalamount", nullable = false)
	private double finalamount;
	private int requestid;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Reimbursements_reimbreq", joinColumns = @JoinColumn(name = "requestid"), inverseJoinColumns = @JoinColumn(name = "rr_id"))
	private List<ReimbRequests> reimb;

	public Reimbursements() {
		super();
	}

	public Reimbursements(int id, Date disbursedon, double finalamount, int requestid) {
		super();
		this.id = id;
		this.disbursedon = disbursedon;
		this.finalamount = finalamount;
		this.requestid = requestid;
	}

	public Reimbursements(Date disbursedon, double finalamount, int requestid) {
		super();
		this.disbursedon = disbursedon;
		this.finalamount = finalamount;
		this.requestid = requestid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDisbursedon() {
		return disbursedon;
	}

	public void setDisbursedon(Date disbursedon) {
		this.disbursedon = disbursedon;
	}

	public double getFinalamount() {
		return finalamount;
	}

	public void setFinalamount(double finalamount) {
		this.finalamount = finalamount;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	@Override
	public String toString() {
		return "Reimbursements [id=" + id + ", disbursedon=" + disbursedon + ", finalamount=" + finalamount
				+ ", requestid=" + requestid + "]";
	}

}
