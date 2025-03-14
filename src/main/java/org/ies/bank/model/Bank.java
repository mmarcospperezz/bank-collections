package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Bank {
    private String name;
    private List<Customer> customers;
    private Map<String, Account> accountsByIban;


    public void addAmount(String iban, double amount) {
        if (accountsByIban.containsKey(iban)) {
            Account account = accountsByIban.get(iban);
            account.setSaldo(account.getSaldo() + amount);
        } else {
            System.out.println("No existe la cuenta");
        }


    }

    public List<Account> getAccountsByCustomerNif(String nif) {
        if (!isCustomerExists(nif)) {
            return null;
        } else {
            List<Account> customerAccounts = new ArrayList<>();
            for (Account account : accountsByIban.values()) {
                if (account.getNif().equals(nif)) {
                    customerAccounts.add(account);
                }
            }
            return customerAccounts;
        }
    }

    private boolean isCustomerExists(String nif) {
        for (Customer customer : customers) {
            if (customer.getNif().equals(nif)) {
                return true;
            }
        }
        return false;
    }

    public void withdrawAmount(String iban, double amount) {
        if (!accountsByIban.containsKey(iban)) {
            System.out.println("No existe la cuenta");
            return;
        }

        Account account = accountsByIban.get(iban);
        if (account.getSaldo() < amount) {
            System.out.println("No hay saldo suficiente");
        } else {
            account.setSaldo(account.getSaldo() - amount);
        }
    }

}

