package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

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

}