package com.bilgeadam.java.tutorials.examples.budget_calculator;

import java.util.Currency;

public class SharedAccount {
    private static final Currency currency = Currency.getInstance("TRY");

    private int balance;

    public synchronized void deposit(int amount){
        balance += Math.max(amount, 0);
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + currency.getSymbol());
        notify();
    }

    public synchronized void withdraw(int amount){
        if (amount > balance){

            try {
                System.out.println(Thread.currentThread().getName() + " is waiting.");
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is awoken.");
            }
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdraw " + amount + currency.getSymbol());

    }

    public String getBalance() {
        return balance + currency.getSymbol();
    }
}
