package com.imatia.imatia_tech_test.controller;

import com.imatia.imatia_tech_test.controller.request.OrderListTrackingRequest;
import com.imatia.imatia_tech_test.dto.OrderTrackingDTO;
import com.imatia.imatia_tech_test.service.OrderTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final OrderTrackingService orderTrackingService;

    @Autowired
    public Controller(OrderTrackingService orderTrackingService) {
        this.orderTrackingService = orderTrackingService;
    }

    @PostMapping("/order/tracking")
    public ResponseEntity<List<OrderTrackingDTO>> addOrderTracking(
            @RequestBody OrderListTrackingRequest orderListTrackingRequest) {
        List<OrderTrackingDTO> result = orderTrackingService.saveOrderTrackingList(
                orderListTrackingRequest.getOrderTrackings());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/order/tracking")
    public ResponseEntity<List<OrderTrackingDTO>> getAllOrderTracking() {
        return ResponseEntity.ok().build();
    }
}
