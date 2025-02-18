package com.example.javanats;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Dispatcher;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class App 
{
    public static void main( String[] args )
    {
        String natsURL = "nats://127.0.0.1:4222";
        while(true){
            try (Connection nc = Nats.connect(natsURL)) {


                byte[] messageBytes = "hello".getBytes(StandardCharsets.UTF_8);


                Dispatcher dispatcher = nc.createDispatcher((msg) -> {
                    System.out.printf("%s on subject %s\n",
                        new String(msg.getData(), StandardCharsets.UTF_8),
                        msg.getSubject());
                });


                dispatcher.subscribe("greet.*");


                nc.publish("greet.sayHello", messageBytes);


                Thread.sleep(1000);


            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
