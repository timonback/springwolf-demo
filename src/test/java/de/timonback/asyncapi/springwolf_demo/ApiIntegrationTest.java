// SPDX-License-Identifier: Apache-2.0
package de.timonback.asyncapi.springwolf_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes = {SpringwolfDemoApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void asyncApiResourceArtifactTest() throws IOException {
        String url = "/springwolf/docs.yaml";
        String actual = restTemplate.getForObject(url, String.class).trim();
        Files.writeString(Path.of("src", "test", "resources", "asyncapi.actual.yaml"), actual);

        InputStream s = this.getClass().getResourceAsStream("/asyncapi.yaml");
        String expected = new String(s.readAllBytes(), StandardCharsets.UTF_8).trim();

        assertEquals(expected, actual);
    }
}
