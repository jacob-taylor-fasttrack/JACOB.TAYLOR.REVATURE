package com.revature.bankingapiCONTROLLERS;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import com.google.gson.Gson;
import com.revature.bankingapiMODELS.Account;
import com.revature.bankingapiMODELS.Client;
import com.revature.bankingapiREPOS.ClientDAO;
import com.revature.bankingapiSERVICES.AccountService;
import com.revature.bankingapiSERVICES.ClientService;

import io.javalin.http.Handler;

public class BankController {
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(BankController.class);
	public ClientDAO cd;

	ClientService cs;
	AccountService as;

	Gson gson = new Gson();

	public BankController(ClientService cs) {
		this.cs = cs;
	}

	// Controller is responsible for managing Application login
	// what is it that our application will need to be able to do

	public Handler getAllClients = (context) -> {

		// creates a list from method
		List<Client> clients = cs.getAllClients();

		context.result(gson.toJson(clients));
	};

	public Handler getClientById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("cId");
		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		Client c = cs.getClient(id);

		if (c != null) {
			ctx.result(gson.toJson(c));

		} else {
			log.info("Missing Client Info");
			ctx.status(404);
		}

	};
	public Handler createClient = (context) -> {

		// Gets values from postman (body)
		Client c = gson.fromJson(context.body(), Client.class);

		c = cs.createClient(c);

		if (c != null) {
			context.result(gson.toJson(c));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateClient = (context) -> {

		// gets values from postman (body)
		Client c = gson.fromJson(context.body(), Client.class);

		// calls specified method
		c = cs.updateClient(c);

		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler deleteClient = (context) -> {

		// gets values from app.class request
		String input = context.pathParam("cId");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Changes Id to interger");
		} catch (NumberFormatException e) {
			log.error("Error with changing id" + e.getMessage());
			id = -1;
		}

		// Calls specified method
		Client c = cs.deleteClient(id);

		if (c != null) {
			// sends results to postman
			context.result(gson.toJson(c));
			context.status(204);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
		;
	};

	public BankController(AccountService as) {
		this.as = as;
	}

	// Controller is responsible for managing Application login
	// what is it that our application will need to be able to do

	public Handler getAllAccounts = (context) -> {
		// Gets variables/values to use from app.class/client side
		String input = context.pathParam("cId");
		String firstParam = context.queryParam("balance<");
		String secondParam = context.queryParam("balance>", "0");
		int id;
		int param1;
		int param2;

		// For query parameters specifically
		if (firstParam != null) {
			try {
				log.info("Putting Params and Id into integer");
				id = Integer.parseInt(input);
				param1 = Integer.parseInt(firstParam);
				param2 = Integer.parseInt(secondParam);

			} catch (NumberFormatException e) {
				log.error("Error while retrieving parameters/id" + e.getMessage());
				id = -1;
				param1 = -1;
				param2 = -1;
			}
			List<Account> accounts = as.getAllAccountsByParam(id, param1, param2);

			// Sends the Information back
			if (!accounts.isEmpty()) {
				context.result(gson.toJson(accounts));
			} else {
				log.error("Missing Account Information");
				context.status(404);
			}
		} else {
			// For calling all accounts within specific id
			try {
				id = Integer.parseInt(input);
				log.info("Putting Id into integer");
			} catch (NumberFormatException e) {
				log.error("Error while retrieving id" + e.getMessage());
				id = -1;
			}
			List<Account> accounts = as.getAllAccounts(id);

			if (!accounts.isEmpty()) {

				// sends list to postman
				context.result(gson.toJson(accounts));

			} else {
				log.error("Missing Account Information");
				context.status(404);
			}
		}
	};

	public Handler getAccountById = (ctx) -> {
		// gets variables/values to use from app.class/client side

		String input = ctx.pathParam("aId");
		String input1 = ctx.pathParam("cId");

		int id;
		int cId;

		try {
			id = Integer.parseInt(input);
			cId = Integer.parseInt(input1);
			log.info("Putting Id's into integer");
		} catch (NumberFormatException e) {
			log.error("Error while retrieving id's" + e.getMessage());
			id = -1;
			cId = -1;
		}

		Account a = as.getAccount(id, cId);

		if (a != null) {

			// sends info to postman
			ctx.result(gson.toJson(a));

		} else {
			log.error("Missing Account Information");
			ctx.status(404);
		}

	};
	public Handler createAccount = (context) -> {

		// Receives info from postman (body)
		Account a = gson.fromJson(context.body(), Account.class);

		a = as.createAccount(a);

		if (a != null) {

			// sends info to postman
			context.result(gson.toJson(a));
			context.status(201);

		} else {
			log.error("Missing Account Information");
			context.status(404);
		}
	};

	public Handler updateAccount = (context) -> {

		// Gets values from postman (body)
		Account a = gson.fromJson(context.body(), Account.class);

		a = as.updateAccount(a);
		if (a != null) {

			// sends info to postman
			context.result(gson.toJson(a));
		} else {
			log.error("Missing Account Information");
			context.status(404);
		}
	};

	public Handler deleteAccount = (context) -> {

		// Gets variables/values to use from app.class/client side
		String input1 = context.pathParam("cId");
		String input = context.pathParam("aId");

		int id;
		int id1;

		try {
			id = Integer.parseInt(input);
			id1 = Integer.parseInt(input1);
			log.info("Putting Id's into integer");
		} catch (NumberFormatException e) {
			log.error("Error while retrieving id's" + e.getMessage());
			id = -1;
			id1 = -1;
		}
		// calls specified method
		Account a = as.deleteAccount(id, id1);

		// returns results
		if (a != null) {
			// sends info to postman
			context.result(gson.toJson(a));
		} else {
			log.error("Missing Account Information");
			context.status(404);
		}
	};

	public Handler withdrawOrDeposit = (ctx) -> {

		// Gets variables
		String input1 = ctx.pathParam("cId");
		String input = ctx.pathParam("aId");

		int id;
		int id1;

		try {
			id = Integer.parseInt(input);
			id1 = Integer.parseInt(input1);
			log.info("Putting Id's into integer");
		} catch (NumberFormatException e) {
			log.error("Error while retrieving id's" + e.getMessage());
			id = -1;
			id1 = -1;
		}
		// calls specified method
		Account a = as.getAccount(id, id1);

		// returns results
		if (a == null) {
			log.error("Missing Account Information");
			ctx.status(404);
		} else {
			// gets amount from postman(body)
			Account b = gson.fromJson(ctx.body(), Account.class);

			// puts amount into the account being called
			Account c = as.updateAccount(a, b);

			Account newA = null;

			// withdraw happens when amount is less than balance and negative
			if (c.getBalance() > Math.abs(c.getAmount()) && c.getAmount() < 0) {
				log.info("Checked Balance for Withdraw");
				newA = as.withdraw(a, c);
				ctx.result(gson.toJson(newA));

				// deposit happens when amount is a positive number
			} else if (c.getAmount() > 0) {
				log.info("Depositing Money");
				newA = as.deposit(a, c);
				ctx.result(gson.toJson(newA));
			} else {
				log.error("Balance Too Low!");
				ctx.status(422);
			}
		}
	};

	public Handler transfer = (ctx) -> {

		// Variables
		String input = ctx.pathParam("aId");
		String input1 = ctx.pathParam("cId");
		String input2 = ctx.pathParam("id");

		int id;
		int cId;
		int id2;

		// transfer variables to integer
		try {
			id = Integer.parseInt(input);
			cId = Integer.parseInt(input1);
			id2 = Integer.parseInt(input2);
			log.info("Putting Id's into integer");
		} catch (NumberFormatException e) {
			log.error("Error while retrieving id's" + e.getMessage());
			id = -1;
			cId = -1;
			id2 = -1;
		}

		// gets both accounts to transfer
		Account fromAccount = as.getAccount(id, cId);
		Account toAccount = as.getAccount(id2, cId);

		if (fromAccount == null || toAccount == null) {
			log.error("Missing Account Information");
			ctx.status(404);
		} else {

			// Gets amount from postman(body)
			Account givenAccount = gson.fromJson(ctx.body(), Account.class);

			// puts amount into both accounts
			Account newInfo = as.updateAccount(fromAccount, givenAccount);
			Account newInfo1 = as.updateAccount(toAccount, givenAccount);

			// checks to see if money can be taken out
			if (newInfo.getBalance() > Math.abs(newInfo.getAmount())) {
				log.info("Checked Balance for Transfer");
				Account newA = as.withdraw(fromAccount, newInfo);

				Account newB = as.deposit(toAccount, newInfo1);

				ctx.result(gson.toJson(newA) + gson.toJson(newB));
			} else {
				log.error("Balance Too Low!");
				ctx.status(422);
			}
		}
	};

}
