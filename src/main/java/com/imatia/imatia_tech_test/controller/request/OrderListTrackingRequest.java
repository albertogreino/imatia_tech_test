package com.imatia.imatia_tech_test.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderListTrackingRequest {
    List<OrderTrackingRequest> orderTrackings;

    public List<OrderTrackingRequest> getOrderTrackings() {
        return orderTrackings;
    }

    public void setOrderTrackings(List<OrderTrackingRequest> orderTrackings) {
        this.orderTrackings = orderTrackings;
    }
}
