package com.revature.bankingapiMODELS;

import org.apache.logging.log4j.LogManager;

public class Client {
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(Client.class);
	String firstname;
	String lastname;
	int id;
	String email;
	String password;

	public Client() {
		super();
	}

	public Client(String firstname, String lastname, int id, String email, String password) {
		super();
		log.info("Setting Client Values");
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstname + ", lastName=" + lastname + ", id=" + id + ", email=" + email
				+ ", password=" + password + "]";
	}

}
