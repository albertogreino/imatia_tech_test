package com.imatia.imatia_tech_test.service.impl;

import com.imatia.imatia_tech_test.controller.request.OrderTrackingRequest;
import com.imatia.imatia_tech_test.dto.OrderTrackingDTO;
import com.imatia.imatia_tech_test.service.OrderTrackingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {
    @Override
    public List<OrderTrackingDTO> saveOrderTrackingList(List<OrderTrackingRequest> orderTrackingRequestList) {
        return orderTrackingRequestList.stream().map(OrderTrackingRequest -> {
            OrderTrackingDTO orderTrackingDTO = new OrderTrackingDTO();
            orderTrackingDTO.setOrderId(OrderTrackingRequest.getOrderId());
            orderTrackingDTO.setStatusId(OrderTrackingRequest.getTrackingStatusId());
            orderTrackingDTO.setChangeStatusDate(OrderTrackingRequest.getChangeStatusDate());
            return orderTrackingDTO;
        }).collect(Collectors.toList());
    }
}
