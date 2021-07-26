package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EventTypes")
public class EventTypes {
	@Id
	@Column(name = "eventTypes_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "typename", nullable = false)
	private String typename;
	@Column(name = "coveragepercent", nullable = false)
	private double coveragepercent;

	public EventTypes() {
		super();
	}

	public EventTypes(int id, String typename, double coveragepercent) {
		super();
		this.id = id;
		this.typename = typename;
		this.coveragepercent = coveragepercent;
	}

	public EventTypes(String typename, double coveragepercent) {
		super();
		this.typename = typename;
		this.coveragepercent = coveragepercent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public double getCoveragepercent() {
		return coveragepercent;
	}

	public void setCoveragepercent(double coveragepercent) {
		this.coveragepercent = coveragepercent;
	}

	@Override
	public String toString() {
		return "EventTypes [id=" + id + ", typename=" + typename + ", coveragepercent=" + coveragepercent + "]";
	}

}
