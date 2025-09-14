// SPDX-License-Identifier: Apache-2.0
package de.timonback.asyncapi.springwolf_demo.consumer;

import de.timonback.asyncapi.springwolf_demo.dto.AnotherPayloadDto;
import de.timonback.asyncapi.springwolf_demo.dto.ExamplePayloadDto;
import de.timonback.asyncapi.springwolf_demo.producer.AnotherProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExampleConsumer {

    @KafkaListener(topics = "example-topic")
    public void receiveExamplePayload(@Payload ExamplePayloadDto payload) {
        log.info("Received new message in another-topic: {}", payload.toString());
    }
}
