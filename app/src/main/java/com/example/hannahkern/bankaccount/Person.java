package com.example.hannahkern.bankaccount;

import java.util.UUID;

/**
 * Created by hannahkern on 18.04.18.
 */

public class Person {

    private String name;
    private String passwort;
    private String accountnr;
    private UUID id;

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(String withdraw) {
        this.withdraw = withdraw;
    }

    private String balance;
    private String withdraw;


    public Person() {
        this.name = name;
        this.passwort = passwort;
        this.accountnr = accountnr;
        this.balance = balance;
    }

}
