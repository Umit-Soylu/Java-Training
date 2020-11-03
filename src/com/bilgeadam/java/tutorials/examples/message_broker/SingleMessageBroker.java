package com.bilgeadam.java.tutorials.examples.message_broker;

public class SingleMessageBroker implements MessageBroker{
    // The message to be send or receive
    private String messages;

    // Set true if message is sending, false otherwise
    private boolean isMessageInTransfer = true;


    /**
     * This method sends messages whenever situation is applicable
     *
     * @param newMessage Message to be send
     */
    @Override
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
        messages = newMessage;

        System.out.println(this.getClass().getSimpleName() + ": new message is received");

        // Notify all threads if there is any waiting
        notifyAll();
    }

    /**
     * This method receives the current message
     *
     * @return The message to return
     */
    @Override
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

        return messages;
    }

}
