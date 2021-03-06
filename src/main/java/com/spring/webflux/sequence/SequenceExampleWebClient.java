package com.spring.webflux.sequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalTime;

public class SequenceExampleWebClient {

    private static Logger log = LoggerFactory.getLogger(SequenceExampleWebClient.class);

    private WebClient client = WebClient.create("http://localhost:8080");

    public static void main(String[] args) {
        SequenceExampleWebClient sequenceExampleWebClient = new SequenceExampleWebClient();
        sequenceExampleWebClient.sequence();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sequence() {
        client.get().uri("/sequence") //Change the URI to /sequenceController to use annotation-based model.
          .accept(MediaType.APPLICATION_STREAM_JSON)
          .exchange()
          .flatMapMany(response -> response.bodyToFlux(Integer.class))
          .subscribe(seq ->
            {System.out.println("Sequence Number: " + seq + " - Time: " + LocalTime.now());},
            err -> System.out.println("Stream Error: " + err),
            () -> System.out.println("Stream Stopped!"));
    }

}
