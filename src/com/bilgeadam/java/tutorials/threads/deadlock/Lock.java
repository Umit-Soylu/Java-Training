package com.bilgeadam.java.tutorials.threads.deadlock;

public class Lock {
    private final String name;

    public Lock(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lock-" + name;
    }
}
