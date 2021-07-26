package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GradingFormats")
public class GradingFormats {
	@Id
	@Column(name = "gradingformat_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "formatname", nullable = false)
	private String formatname;
	@Column(name = "description")
	private String description;
	@Column(name = "defaultgrade")
	private String defaultgrade;

	public GradingFormats() {
		super();
	}

	public GradingFormats(int id, String formatname, String description, String defaultgrade) {
		super();
		this.id = id;
		this.formatname = formatname;
		this.description = description;
		this.defaultgrade = defaultgrade;
	}

	public GradingFormats(String formatname, String description, String defaultgrade) {
		super();
		this.formatname = formatname;
		this.description = description;
		this.defaultgrade = defaultgrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormatname() {
		return formatname;
	}

	public void setFormatname(String formatname) {
		this.formatname = formatname;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public String getDefaultgrade() {
		return defaultgrade;
	}

	public void setDefaultgrade(String defaultgrade) {
		this.defaultgrade = defaultgrade;
	}

	@Override
	public String toString() {
		return "GradingFormats [id=" + id + ", formatname=" + formatname + ", description=" + description
				+ ", defaultgrade=" + defaultgrade + "]";
	}

}
