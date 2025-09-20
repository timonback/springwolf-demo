// SPDX-License-Identifier: Apache-2.0
package de.timonback.asyncapi.springwolf_demo.producer;

import de.timonback.asyncapi.springwolf_demo.dto.AnotherPayloadDto;
import io.github.springwolf.bindings.kafka.annotations.KafkaAsyncOperationBinding;
import io.github.springwolf.core.asyncapi.annotations.AsyncOperation;
import io.github.springwolf.core.asyncapi.annotations.AsyncPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AnotherProducer {

    @Autowired
    private KafkaTemplate<String, AnotherPayloadDto> kafkaTemplate;

    @AsyncPublisher(operation = @AsyncOperation(
            channelName = "another-topic",
            description = "Sends another payload message"
    ))
    @KafkaAsyncOperationBinding
    public void sendMessage(AnotherPayloadDto msg) {
        kafkaTemplate.send("another-topic", msg);
    }
}
