package com.bilgeadam.java.tutorials.examples.message_broker;

import java.util.LinkedList;

public class MultiMessageBroker implements MessageBroker {

    // Linked List is not thread safe so we need to implement out own solution.
    private final LinkedList<String> messages = new LinkedList<>();

    /**
     * This method sends messages whenever situation is applicable
     *
     * @param message Message to be send
     */
    public synchronized void sendMessage(String message){
        messages.add(message);
        notifyAll();
    }

    /**
     * This method receives the current message
     *
     * @return The message to return
     */
    public synchronized String receiveMessage(){
        notifyAll();
        return messages.isEmpty() ? null : messages.pop();
    }
}
