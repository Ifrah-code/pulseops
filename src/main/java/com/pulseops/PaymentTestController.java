
package com.pulseops;

import com.pulseops.client.PaymentClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentTestController {

    private final PaymentClient paymentClient;

    public PaymentTestController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @GetMapping("/api/test-payment")
    public String testPayment() {
        return paymentClient.checkPaymentService();
    }
}
