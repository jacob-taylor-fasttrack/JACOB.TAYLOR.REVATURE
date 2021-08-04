package com.revature.bankingapiAPP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.bankingapiMODELS.Account;
import com.revature.bankingapiREPOS.AccountDAO;
import com.revature.bankingapiREPOS.AccountDAOImpl;

public class AccountDAOImplTest {
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
		Account test = ad.createAccount(a);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testGetAccountInt() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAccountIntInt() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.getAccount(1, 2);
		assertEquals(test.getId(), 1);
		assertEquals(test.getCid(), 2);
	}

	@Test
	public void testGetAllAccounts() {
		AccountDAO ad = new AccountDAOImpl();
		List<Account> test = ad.getAllAccounts();
		assertNotNull(test);
	}

	@Test
	public void testGetAllAccountsInt() {
		AccountDAO ad = new AccountDAOImpl();
		List<Account> test = ad.getAllAccounts(1);
		assertNotNull(test);
	}

	@Test
	public void testGetAllAccountsByParam() {
		AccountDAO ad = new AccountDAOImpl();
		List<Account> test = ad.getAllAccountsByParam(1, 2000, 400);
		assertNotNull(test);
	}

	@Test
	public void testUpdateAccountAccount() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.updateAccount(a);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testDeleteAccountInt() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.deleteAccount(12);
		assertEquals(null, test);
	}

	@Test
	public void testWithdraw() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.withdraw(a, b);
		assertEquals(test.getAmount(), -100);
	}

	@Test
	public void testDeposit() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.deposit(a, c);
		assertNotNull(test);
		assertEquals(test.getAmount(), 100);
	}

	@Test
	public void testDeleteAccountInt2() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.deleteAccount(1, 2);
		assertEquals(null, test);
	}

	@Test
	public void testUpdateAccount() {
		AccountDAO ad = new AccountDAOImpl();
		Account test = ad.updateAccount(a, c);
		assertEquals(test.getAmount(), 100);
	}

}
