package com.bilgeadam.java.tutorials.examples.message_broker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiMessageBrokerTest {

    private MultiMessageBroker broker;

    @BeforeEach
    void setUp() {
        broker = new MultiMessageBroker();
    }

    @AfterEach
    void tearDown() {
        broker = null;
    }

    @Test
    void SingleSenderReceiver() throws InterruptedException {
        Thread sender = new Thread(new Sender(broker)),
                receiver = new Thread(new Receiver(broker));

        sender.start();
        receiver.start();

        sender.join();
        receiver.join();
    }

    @Test
    void MultipleSenderReceiver() throws InterruptedException {
        int nbOfThreads = 4, nbOfSenders = 3, nbOfReceivers = 3, currentSenders = 0, currentReceivers = 0;

        ExecutorService poolExecutor = Executors.newFixedThreadPool(nbOfThreads);

        while (currentSenders < nbOfSenders || currentReceivers < nbOfReceivers){
            if (currentSenders++ < nbOfSenders)
                poolExecutor.execute(new Sender(broker));

            if (currentReceivers++ < nbOfReceivers)
                poolExecutor.execute(new Receiver(broker));
        }

        poolExecutor.shutdown();
        poolExecutor.awaitTermination(15, TimeUnit.SECONDS);

        assertTrue(poolExecutor.isShutdown());

    }
}