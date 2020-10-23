package com.bilgeadam.java.tutorials.examples.message_broker;

import java.util.Stack;

public class MessageBroker {
    // The message to be send or receive
    private final Stack<String> messages = new Stack<>();

    // Set true if message is sending, false otherwise
    private boolean isMessageInTransfer = true;


    /**
     * This method sends messages whenever situation is applicable
     *
     * @param newMessage Message to be send
     */
    public synchronized void sendMessage(String newMessage) {
        while(!isMessageInTransfer){
            try {
                wait();
            } catch (InterruptedException exception){
                Thread.currentThread().interrupt();
                System.out.println("I am interrupted");
            }
        }

        isMessageInTransfer = false;
        messages.push(newMessage);

        System.out.println(this.getClass().getSimpleName() + ": new message is received");

        // Notify all threads if there is any waiting
        notifyAll();
    }

    /**
     * This method receives the current message
     *
     * @return The message to return
     */
    public synchronized String receiveMessage(){
        while (isMessageInTransfer){
            try {
                wait();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                System.out.println("I am interrupted.");
            }
        }

        isMessageInTransfer = true;

        // Notify all threads if there is any waiting
        notifyAll();

        System.out.println(this.getClass().getSimpleName() + ": a message is sending");

        return messages.isEmpty() ? null : messages.pop();
    }

}
