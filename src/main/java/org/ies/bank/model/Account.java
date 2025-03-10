package org.ies.bank.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String iban;
    private String nif;
    private double saldo;
}
