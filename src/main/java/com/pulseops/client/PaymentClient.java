package com.pulseops.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component

public class PaymentClient {
	
	private final RestClient restClient;

    public PaymentClient(RestClient restClient) {
        this.restClient = restClient;
    }
    

public String checkPaymentService() {
    return restClient.get()
            .uri("http://localhost:8081/api/payments/health")
            .retrieve()
            .body(String.class);
}


}
