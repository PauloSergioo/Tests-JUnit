package testes.factory;

import entities.Account;

public class AccountFactory {
    public static entities.Account cretedEmptyAccount() {
        return new Account(1L, 0.0);
    }

    public static entities.Account createdAccount(double initialBalance) {
        return new Account(1L, initialBalance);
    }
}
