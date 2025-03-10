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
}
