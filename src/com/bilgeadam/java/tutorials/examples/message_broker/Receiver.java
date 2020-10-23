package com.bilgeadam.java.tutorials.examples.message_broker;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable{
    private final MessageBroker broker;

    /**
     * Constructor acquires Message Broker for receiving messages
     * @param broker Message Broker to be used
     */
    public Receiver(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        for (String message = broker.receiveMessage(); !Sender.lastMessage.equals(message); message = broker.receiveMessage()){
            System.out.println(this.getClass().getSimpleName() + ": received message is '" + message + "'.");

            SleepRandomly();
        }
    }

    /**
     * Sleep randomly after sending a message
     */
    private void SleepRandomly(){
        try {
            // Use random generator only for current thread
            Thread.sleep(ThreadLocalRandom.current().nextInt(300, 700));
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println(this.getClass().getSimpleName() + " is interrupted!");
        }
    }
}
