package com.revature.bankingapiREPOS;

import java.util.List;

import com.revature.bankingapiMODELS.Account;

public interface AccountDAO {
	public Account createAccount(Account a);

	public Account getAccount(int id);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account change, Account b);

	public Account deleteAccount(int id);

	public Account withdraw(Account a, Account b);

	public Account deposit(Account a, Account b);

	public List<Account> getAllAccounts(int id);

	public List<Account> getAllAccountsByParam(int id, int param1, int param2);

	public Account getAccount(int id, int id2);

	public Account deleteAccount(int id, int id2);

	public Account updateAccount(Account change);
}
