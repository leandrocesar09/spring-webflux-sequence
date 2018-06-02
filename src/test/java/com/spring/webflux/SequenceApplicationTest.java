package com.spring.webflux;

import com.spring.webflux.sequence.SequenceExampleWebClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SequenceApplicationTest {

    @Test
    public void testSequence() {
        SequenceExampleWebClient sequenceExampleWebClient = new SequenceExampleWebClient();
        sequenceExampleWebClient.sequence();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
