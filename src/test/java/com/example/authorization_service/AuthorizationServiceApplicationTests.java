package com.example.authorization_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorizationServiceApplicationTests {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Container
    private final GenericContainer<?> devappContainer = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);
    @Container
    private final GenericContainer<?> prodappContainer = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntityDevapp = testRestTemplate.getForEntity("http://localhost:" + devappContainer.getMappedPort(8080), String.class);
        ResponseEntity<String> forEntityProdapp = testRestTemplate.getForEntity("http://localhost:" + prodappContainer.getMappedPort(8081), String.class);
        System.out.println(forEntityDevapp.getBody());
        System.out.println(forEntityProdapp.getBody());
    }

}
