package com.revature.bankingapiAPP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.bankingapiMODELS.Account;
import com.revature.bankingapiREPOS.AccountDAO;
import com.revature.bankingapiREPOS.AccountDAOImpl;
import com.revature.bankingapiSERVICES.AccountService;
import com.revature.bankingapiSERVICES.AccountServicesImpl;

public class AccountServiceTest {
	private Account a;
	private Account b;
	private Account c;

	@Before
	public void init() {
		a = new Account();
		a.setCid(1);
		a.setBalance(100);
		a.setAmount(0);
		a.setCheckingAccount(true);
		a.setSavingsAccount(false);

		b = new Account();
		b.setAmount(-100);

		c = new Account();
		c.setAmount(100);
	}

	@Test
	public void testCreateAccount() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.createAccount(a);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testGetAccountInt() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testGetAccountIntInt() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.getAccount(1, 2);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
		assertEquals(test.getCid(), 2);
	}

	@Test
	public void testGetAllAccounts() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		List<Account> test = ar.getAllAccounts();
		assertNotNull(test);
	}

	@Test
	public void testUpdateAccountAccount() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.updateAccount(a);
		assertNotNull(test);
	}

	@Test
	public void testDeleteAccountInt() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.deleteAccount(1);
		assertNotNull(test);
		assertEquals(null, test);
	}

	@Test
	public void testGetAllAccountsInt() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		List<Account> test = ar.getAllAccounts(1);
		assertNotNull(test);
	}

	@Test
	public void testDeleteAccountIntInt() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.deleteAccount(1, 2);
		assertNotNull(test);
	}

	@Test
	public void testGetAllAccountsByParam() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		List<Account> test = ar.getAllAccountsByParam(1, 2000, 400);
		assertNotNull(test);
	}

	@Test
	public void testDeposit() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.deposit(a, b);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testUpdateAccountAccountAccount() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testWithdraw() {
		AccountDAO ad = new AccountDAOImpl();
		AccountService ar = new AccountServicesImpl(ad);
		Account test = ar.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

}
