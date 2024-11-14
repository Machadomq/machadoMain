package entities;

import exception.ExceedWithdrawLimitException;
import exception.InsufficientBalanceException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withDraw(Double withDrawAmount) throws ExceedWithdrawLimitException, InsufficientBalanceException {
		if (withDrawAmount > balance) {
			throw new InsufficientBalanceException("Saldo insuficiente");
		} else if (withDrawAmount > withdrawLimit) {
			throw new ExceedWithdrawLimitException(""
					+ "Saque excede o limite da conta.");
		}
		else {
			balance -= withDrawAmount;
		}
	}

}
