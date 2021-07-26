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
@Table(name = "ReimbRequests")
public class ReimbRequests {
	@Id
	@Column(name = "rr_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int employee;
	private int event;
	private String justification;
	private double timerequired;
	private boolean urgent;
	private Date lastupdated;
	private String pendingresponsefrom;
	private double proposedamount;
	private String decision;
	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Requests_Events", joinColumns = @JoinColumn(name = "event"), inverseJoinColumns = @JoinColumn(name = "events_id"))
	private List<Events> eventsrequests;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Requests_Employees", joinColumns = @JoinColumn(name = "employee"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employees> employeerequests;

	public ReimbRequests() {
		super();
	}

	public ReimbRequests(int id, int employee, int event, String justification, double timerequired, boolean urgent,
			Date lastupdated, String pendingresponsefrom, double proposedamount, String decision) {
		super();
		this.id = id;
		this.employee = employee;
		this.event = event;
		this.justification = justification;
		this.timerequired = timerequired;
		this.urgent = urgent;
		this.lastupdated = lastupdated;
		this.pendingresponsefrom = pendingresponsefrom;
		this.proposedamount = proposedamount;
		this.decision = decision;
	}

	public ReimbRequests(int employee, int event, String justification, double timerequired, boolean urgent,
			Date lastupdated, String pendingresponsefrom, double proposedamount, String decision) {
		super();
		this.employee = employee;
		this.event = event;
		this.justification = justification;
		this.timerequired = timerequired;
		this.urgent = urgent;
		this.lastupdated = lastupdated;
		this.pendingresponsefrom = pendingresponsefrom;
		this.proposedamount = proposedamount;
		this.decision = decision;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee() {
		return employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public double getTimerequired() {
		return timerequired;
	}

	public void setTimerequired(double timerequired) {
		this.timerequired = timerequired;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public Date getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public String getPendingresponsefrom() {
		return pendingresponsefrom;
	}

	public void setPendingresponsefrom(String pendingresponsefrom) {
		this.pendingresponsefrom = pendingresponsefrom;
	}

	public double getProposedamount() {
		return proposedamount;
	}

	public void setProposedamount(double proposedamount) {
		this.proposedamount = proposedamount;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	@Override
	public String toString() {
		return "ReimbRequests [id=" + id + ", employee=" + employee + ", event=" + event + ", justification="
				+ justification + ", timerequired=" + timerequired + ", urgent=" + urgent + ", lastupdated="
				+ lastupdated + ", pendingresponsefrom=" + pendingresponsefrom + ", proposedamount=" + proposedamount
				+ ", decision=" + decision + ", amount=" + amount + ", eventsrequests=" + eventsrequests
				+ ", employeerequests=" + employeerequests + "]";
	}

}
