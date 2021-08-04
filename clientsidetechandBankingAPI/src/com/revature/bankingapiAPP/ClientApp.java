package com.revature.bankingapiAPP;

import com.revature.bankingapiCONTROLLERS.BankController;
import com.revature.bankingapiREPOS.AccountDAO;
import com.revature.bankingapiREPOS.AccountDAOImpl;
import com.revature.bankingapiREPOS.ClientDAO;
import com.revature.bankingapiREPOS.ClientDAODBimpl;
import com.revature.bankingapiSERVICES.AccountService;
import com.revature.bankingapiSERVICES.AccountServicesImpl;
import com.revature.bankingapiSERVICES.ClientService;
import com.revature.bankingapiSERVICES.ClientServiceImpl;

import io.javalin.Javalin;

public class ClientApp {

	public static void main(String[] args) {
		// Establish our Javalin Object
		Javalin app = Javalin.create();

		// Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);

		// Run Javalin
		app.start(7000);

	}

	private static void establishRoutes(Javalin app) {

		// Going to define a list of routes/endpoints Javalin will manage
		ClientDAO cd = new ClientDAODBimpl();
		ClientService cs = new ClientServiceImpl(cd);
		BankController bc = new BankController(cs);

		AccountDAO ad = new AccountDAOImpl();
		AccountService as = new AccountServicesImpl(ad);
		BankController ac = new BankController(as);

		// Establish a route to the 'landing' page
		app.get("/", (ctx) -> ctx.result("This is Our Banking App Home Page!"));

		// Establish routes to every possibility
		app.get("/clients", bc.getAllClients);
		app.get("/clients/:cId", bc.getClientById);

		app.get("/clients/:cId/accounts", ac.getAllAccounts);
		app.get("/clients/:cId/accounts/:aId", ac.getAccountById);

		app.post("/clients/:cid", bc.createClient);

		app.post("/clients/:cId/accounts", ac.createAccount);

		app.put("/clients/:cId", bc.updateClient);

		app.put("/clients/:cId/accounts/:aId", ac.updateAccount);

		app.delete("/clients/:cId", bc.deleteClient);

		app.delete("/clients/:cId/accounts/:aId", ac.deleteAccount);

		app.patch("/clients/:cId/accounts/:aId", ac.withdrawOrDeposit);

		app.patch("/clients/:cId/accounts/:aId/transfer/:id", ac.transfer);
	}
	/*
	 * POST /clients => Creates a new client return a 201 status code
	 * 
	 * GET /clients => gets all clients return 200
	 * 
	 * GET /clients/10 => get client with id of 10 return 404 if no such client
	 * exist
	 * 
	 * PUT /clients/12 => updates client with id of 12 return 404 if no such client
	 * exist
	 * 
	 * DELETE /clients/15 => deletes client with the id of15 return 404 if no such
	 * client exist return 205 if success
	 * 
	 * 
	 * POST /clients/5/accounts =>creates a new account for client with the id of 5
	 * return a 201 status code
	 * 
	 * GET /clients/7/accounts => get all accounts for client 7 return 404 if no
	 * client exists
	 * 
	 * GET /clients/7/accounts?amountLessThan=2000&amountGreaterThan400 => get all
	 * accounts for client 7 between 400 and 2000 return 404 if no client exists
	 * 
	 * GET /clients/9/accounts/4 => get account 4 for client 9 return 404 if no
	 * account or client exists
	 * 
	 * PUT /clients/10/accounts/3 => update account with the id 3 for client 10
	 * return 404 if no account or client exists
	 * 
	 * DELETE /clients/15/accounts/6 => delete account 6 for client 15 return 404 if
	 * no account or client exists
	 * 
	 * 
	 * PATCH /clients/17/accounts/12 => Withdraw/deposit given amount (Body:
	 * {"deposit":500} or {"withdraw":250} return 404 if no account or client exists
	 * return 422 if insufficient funds
	 * 
	 * PATCH /clients/12/accounts/7/transfer/8 => transfer funds from account 7 to
	 * account 8 (Body: {"amount":500}) return 404 if no client or either account
	 * exists return 422 if insufficient funds
	 * 
	 */

}
