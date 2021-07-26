package com.revature.models;

import java.sql.Time;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Events")
public class Events {
	@Id
	@Column(name = "events_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date eventdate;
	private Time eventtime;
	private String eventlocation;
	private String description;
	private double cost;

	private int passingGrade;

	@ManyToOne
	@JoinColumn(name = "eventType")
	private Events eventType;
	@ManyToOne
	@JoinColumn(name = "gradingFormat")
	private Events gradingformat;

	public Events() {
		super();
	}

	public Events(int id, Date eventdate, Time eventtime, String eventlocation, String description, double cost,
			Events eventType, Events gradingformat, int passingGrade) {
		super();
		this.id = id;
		this.eventdate = eventdate;
		this.eventtime = eventtime;
		this.eventlocation = eventlocation;
		this.description = description;
		this.cost = cost;
		this.eventType = eventType;
		this.gradingformat = gradingformat;
		this.passingGrade = passingGrade;
	}

	public Events(Date eventdate, Time eventtime, String eventlocation, String description, double cost,
			Events eventType, Events gradingformat, int passingGrade) {
		super();
		this.eventdate = eventdate;
		this.eventtime = eventtime;
		this.eventlocation = eventlocation;
		this.description = description;
		this.cost = cost;
		this.eventType = eventType;
		this.gradingformat = gradingformat;
		this.passingGrade = passingGrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEventdate() {
		return eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	public Time getEventtime() {
		return eventtime;
	}

	public void setEventtime(Time eventtime) {
		this.eventtime = eventtime;
	}

	public String getEventlocation() {
		return eventlocation;
	}

	public void setEventlocation(String eventlocation) {
		this.eventlocation = eventlocation;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Events getEventType() {
		return eventType;
	}

	public void setEventType(Events eventType) {
		this.eventType = eventType;
	}

	public Events getGradingformat() {
		return gradingformat;
	}

	public void setGradingformat(Events gradingformat) {
		this.gradingformat = gradingformat;
	}

	public int getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(int passingGrade) {
		this.passingGrade = passingGrade;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", eventdate=" + eventdate + ", eventtime=" + eventtime + ", eventlocation="
				+ eventlocation + ", description=" + description + ", cost=" + cost + ", eventType=" + eventType
				+ ", gradingformat=" + gradingformat + ", passingGrade=" + passingGrade + "]";
	}

}
