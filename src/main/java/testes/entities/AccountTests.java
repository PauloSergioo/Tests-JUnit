package main.java.testes.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {

        double amount = 200.0;
        double expectedValue = 196.0;
        entities.Account acc = AccountFactory.cretedEmptyAccount();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {

        double expectedValue = 100.0;
        Account acc = AccountFactory.createdAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndResultFullBalance() {

        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createdAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {

        Account acc = AccountFactory.createdAccount(800.0);

        acc.withdraw(500.0);

        Assertions.assertEquals(300.0, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Account acc = AccountFactory.createdAccount(800.0);

            acc.withdraw(801.0);
        });
    }
}
