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
        boolean customerExists = false;
        for (Customer customer : customers) {
            if (customer.getNif().equals(nif)) {
                customerExists = true;
            }
        }

        if (!customerExists) {
            return null;
        }

        List<Account> customerAccounts = new ArrayList<>();
        for (Account account : accountsByIban.values()) {
            if (account.getNif().equals(nif)) {
                customerAccounts.add(account);
            }
        }
        return customerAccounts;
    }
}

