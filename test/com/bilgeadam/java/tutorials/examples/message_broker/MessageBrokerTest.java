package com.bilgeadam.java.tutorials.examples.message_broker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageBrokerTest {

    private MessageBroker broker;

    private Thread sender, receiver;

    @BeforeEach
    void setUp() {
        broker = new MessageBroker();
        sender = new Thread(new Sender(broker), "Sender");
        receiver = new Thread(new Receiver(broker), "Receiver");
    }

    @AfterEach
    void tearDown() {
        broker = null;
        sender = null;
        receiver = null;
    }

    @Test
    void SendReceiveMessages() throws InterruptedException {
        sender.start();
        receiver.start();

        // Force current test method to wait till sender & receiver threads die
        sender.join();
        receiver.join();
    }
}