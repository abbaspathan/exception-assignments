package com.capgemini.facotrial.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.DebitLimitExceedException;
import com.capgemini.factorial.model.CurrentBankAccount;

public class CurrentBankAccountTest {

	@Test
	public void testWithdrawAmountForCurrentAccountSufficeantBalance() throws DebitLimitExceedException {
		CurrentBankAccount account = new CurrentBankAccount(102, "John Doe", 45000, 20000);
		assertEquals(30000, account.withdraw(15000), 0.01);
	}

	@Test
	public void testWithdrawAmountForCurrentAccountInSufficeantBalanceUsingDebitAmount()
			throws DebitLimitExceedException {
		CurrentBankAccount account = new CurrentBankAccount(102, "John Doe", 45000, 20000);
		account.withdraw(50000);
		assertEquals(5000, account.getBorrowedAmount(), 0.01);
	}

	@Test(expected = DebitLimitExceedException.class)
	public void testWithdrawAmountForCurrentAccountInSufficeantBalanceUsingDebitAmountExceed()
			throws DebitLimitExceedException {
		CurrentBankAccount account = new CurrentBankAccount(102, "John Doe", 45000, 20000);
		account.withdraw(50000);
		account.withdraw(20000);
	}

	@Test
	public void testDepositCurrentAccountWithZeroDebitAmount() {
		CurrentBankAccount account = new CurrentBankAccount(102, "John Doe", 45000, 20000);
		assertEquals(50000, account.deposit(5000), 0.01);
	}

	@Test
	public void testDepositCurrentAccountWithSomeDebitAmount() throws DebitLimitExceedException {
		CurrentBankAccount account = new CurrentBankAccount(102, "John Doe", 45000, 20000);
		account.withdraw(50000);
		assertEquals(1000, account.deposit(6000), 0.01);
	}

	@Test
	public void testDepositCurrentAccountWithDebitAmountExceed() throws DebitLimitExceedException {
		CurrentBankAccount account = new CurrentBankAccount(102, "John Doe", 30000, 20000);
		account.withdraw(50000);
		assertEquals(0, account.deposit(6000), 0.01);
	}
}
