package com.capgemini.factorial.model;

import com.capgemini.exception.DebitLimitExceedException;
import com.capgemini.exception.InsufficeantBalanceException;

public class SavingBankAccount extends BankAccount {

	private boolean salaryAccount;
	public static final double MINIMUM_BALANCE = 10000;

	public SavingBankAccount() {
		super();
	}

	public SavingBankAccount(long accountId, String accountHolderName, double accountBalance, boolean salaryAccount) {
		super(accountId, accountHolderName, "SAVING", accountBalance);
		this.salaryAccount = salaryAccount;
	}

	public boolean isSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(boolean salaryAccount) {
		this.salaryAccount = salaryAccount;
	}

	@Override
	public double withdraw(double amount) throws InsufficeantBalanceException, DebitLimitExceedException {
		if (salaryAccount) {
			return super.withdraw(amount);
		} else {
			if (getAccountBalance() - amount >= MINIMUM_BALANCE) {
				setAccountBalance(getAccountBalance() - amount);
			} else {
				throw new InsufficeantBalanceException("You don't have sufficent amount");
			}
			return getAccountBalance();
		}
	}
}
