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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employees {
	@Id
	@Column(name = "employee_id", updatable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name = "supervisor")
	private Employees supervisor;
	@ManyToOne
	@JoinColumn(name = "depthead")
	private Employees depthead;
	@ManyToOne
	@JoinColumn(name = "benco")
	private Employees benco;
	@ManyToOne
	@JoinColumn(name = "bencocomm")
	private Communication bencocomm;
	@ManyToOne
	@JoinColumn(name = "deptheadcomm")
	private Communication deptheadcomm;
	@ManyToOne
	@JoinColumn(name = "supervisorcomm")
	private Communication supervisorcomm;

	public Employees() {
		super();
	}

	public Employees(int id, String firstname, String lastname, String username, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public Employees(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employees getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employees supervisor) {
		this.supervisor = supervisor;
	}

	public Employees getDepthead() {
		return depthead;
	}

	public void setDepthead(Employees depthead) {
		this.depthead = depthead;
	}

	public Employees getBenco() {
		return benco;
	}

	public void setBenco(Employees benco) {
		this.benco = benco;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", supervisor=" + supervisor + ", depthead=" + depthead + ", benco="
				+ benco + ", supervisorcomm=" + supervisorcomm + ", deptheadcomm=" + deptheadcomm + ", bencocomm="
				+ bencocomm + "]";
	}

}
