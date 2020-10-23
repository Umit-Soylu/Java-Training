package com.bilgeadam.java.tutorials.examples.message_broker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleMessageBrokerTest {

    private SingleMessageBroker broker;

    @BeforeEach
    void setUp() {
        broker = new SingleMessageBroker();

    }

    @AfterEach
    void tearDown() {
        broker = null;
    }

    @Test
    void SendReceiveMessages() throws InterruptedException {
        Thread sender = new Thread(new Sender(broker), "Sender"),
                receiver = new Thread(new Receiver(broker), "Receiver");

        sender.start();
        receiver.start();

        // Force current test method to wait till sender & receiver threads die
        sender.join();
        receiver.join();
    }
}