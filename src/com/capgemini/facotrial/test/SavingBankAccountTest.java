package com.capgemini.facotrial.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.DebitLimitExceedException;
import com.capgemini.exception.InsufficeantBalanceException;
import com.capgemini.factorial.model.SavingBankAccount;

public class SavingBankAccountTest {

	@Test
	public void testWithdrawSavingBankAccountForSalaryAccountSufficeantAmount() throws InsufficeantBalanceException, DebitLimitExceedException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, true);
		assertEquals(25000, account.withdraw(10000),0.01);
	}

	@Test(expected=InsufficeantBalanceException.class)
	public void testWithdrawSavingBankAccountForSalaryAccountInSufficeantAmount() throws InsufficeantBalanceException, DebitLimitExceedException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, true);
		account.withdraw(36000);
	}

	@Test
	public void testWithdrawSavingBankAccountForSavingAccountSufficeantAmount() throws InsufficeantBalanceException, DebitLimitExceedException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, false);
		assertEquals(15000, account.withdraw(20000),0.01);
	}

	@Test(expected=InsufficeantBalanceException.class)
	public void testWithdrawSavingBankAccountForSavingAccountInSufficeantAmount() throws InsufficeantBalanceException, DebitLimitExceedException {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, false);
		account.withdraw(40000);
	}

	@Test
	public void testDepositForSavingBabnkAccountInSalaryAccount() {
		SavingBankAccount account = new SavingBankAccount(101, "John Deo", 35000, true);
		assertEquals(45000, account.deposit(10000),0.01);
	}
}
