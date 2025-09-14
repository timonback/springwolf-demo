// SPDX-License-Identifier: Apache-2.0
package de.timonback.asyncapi.springwolf_demo.consumer;

import de.timonback.asyncapi.springwolf_demo.dto.AnotherPayloadDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class AnotherConsumer {

    @KafkaListener(topics = "another-topic", groupId = "example-group-id")
    public void receiveAnotherPayload(AnotherPayloadDto payload) {
        log.info("Received new message in another-topic: {}", payload.toString());
    }
}
