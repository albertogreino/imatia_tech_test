package com.imatia.imatia_tech_test.controller;

import com.imatia.imatia_tech_test.controller.request.OrderListTrackingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @PostMapping("/order/tracking")
    public ResponseEntity addOrderTracking(
            @RequestBody OrderListTrackingRequest orderListTrackingRequest) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/order/tracking")
    public ResponseEntity getAllOrderTracking() {
        return ResponseEntity.ok().build();
    }
}
