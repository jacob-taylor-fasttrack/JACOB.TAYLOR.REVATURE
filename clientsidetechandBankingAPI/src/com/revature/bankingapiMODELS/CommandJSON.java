package com.revature.bankingapiMODELS;

public class CommandJSON {
	private String command;

	public CommandJSON() {
		super();
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public CommandJSON(String command) {
		super();
		this.command = command;
	}
}
