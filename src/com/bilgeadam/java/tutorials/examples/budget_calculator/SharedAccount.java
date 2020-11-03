package com.bilgeadam.java.tutorials.examples.budget_calculator;

import java.util.Currency;

public class SharedAccount {
    private static final Currency currency = Currency.getInstance("TRY");

    private int balance = 0;


    /**
     * A method to deposit money to the account
     *
     * @param amount The amount in {@code currency}
     */
    public synchronized void deposit(int amount){
        balance += Math.max(amount, 0);
        System.out.println(Thread.currentThread().getName() + ": Deposit success");

        // Wake up any thread waiting for this object
        notify();
    }

    /**
     * A method to withdraw money from account
     *
     * @param amount requested value to withdraw
     */
    public synchronized void withdraw(int amount){
        // Wait till if not enough money exist
        while (amount > balance) {
            System.out.println(Thread.currentThread().getName() + ": Not enough money to withdraw, waiting");

            try {
                wait();
            } catch (InterruptedException exception) {
                //exception.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "!!!!");

            }
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + ": Withdrawal success");
    }

    public String getBalance(){
        return balance + currency.getSymbol();
    }


}
