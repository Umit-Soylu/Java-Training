package com.bilgeadam.java.tutorials.examples.message_broker;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    public static String lastMessage = "EOM";

    private static final String[] messages = {"Message-1", "Message-2", "Message-3", "Message-4",  "Message-5", lastMessage};

    private final MessageBroker broker;

    /**
     * Constructor acquires Message Broker for sending messages
     * @param broker Message Broker to be used
     */
    public Sender(MessageBroker broker) {
        this.broker = broker;
    }

    /**
     * Sends existing messages sequentially
     */
    @Override
    public void run() {
        for (String message : messages) {
            System.out.println(this.getClass().getSimpleName() + ": sending message: '" + message + "'.");

            broker.sendMessage(message);

            SleepRandomly();
        }
    }

    /**
     * Sleep randomly after sending a message
     */
    private void SleepRandomly(){
        try {
            // Use random generator only for current thread
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println(this.getClass().getSimpleName() + " is interrupted!");
        }
    }
}
