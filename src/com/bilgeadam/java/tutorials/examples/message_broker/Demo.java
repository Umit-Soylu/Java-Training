package com.bilgeadam.java.tutorials.examples.message_broker;

public class Demo {

    public static void main(String[] args) {
        SingleMessageBroker broker = new SingleMessageBroker();

        Thread sender = new Thread(new Sender(broker), "Sender"),
                receiver = new Thread(new Receiver(broker), "Receiver");

        sender.start();
        receiver.start();
    }
}
