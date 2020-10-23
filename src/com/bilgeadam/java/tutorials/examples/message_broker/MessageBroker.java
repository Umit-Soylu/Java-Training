package com.bilgeadam.java.tutorials.examples.message_broker;

public interface MessageBroker {

     void sendMessage(String message);

     String receiveMessage();
}
