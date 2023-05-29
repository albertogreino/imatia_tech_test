package com.imatia.imatia_tech_test.service;

import com.imatia.imatia_tech_test.controller.request.OrderTrackingRequest;
import com.imatia.imatia_tech_test.dto.OrderTrackingDTO;

import java.util.List;

public interface OrderTrackingService {
    List<OrderTrackingDTO> saveOrderTrackingList(List<OrderTrackingRequest> orderTrackingRequestList);
}
