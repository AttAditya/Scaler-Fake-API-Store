package com.scaler.midterms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class MidtermsApplicationTests {
	private final RestTemplate restTemplate;

    MidtermsApplicationTests() {
        this.restTemplate = new RestTemplate();
    }

    @Test
	void contextLoads() {
	}

	@Test
    void hello() {
		String resp = restTemplate.getForObject("http://localhost:8080/hello", String.class);
        assert resp.equals("Hello, World!");
	}

}