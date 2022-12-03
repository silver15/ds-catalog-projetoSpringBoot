package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDothingWhenNegativeAmount() {
		
	
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalçance() {
		
	
		double expectedValue = 0.0;
		double inicialBalance = 800.0;
		Account acc = AccountFactory.createAccount(inicialBalance);
		
		double result = acc.fullWithdraw();
		
				
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == inicialBalance);
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceceWhenSufficientBalçance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500.0);
				
				
		Assertions.assertEquals(300.0, acc.getBalance());
		
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenISufficientBalçance() {
		
				
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
			
		});
		
	}
	
	

}
