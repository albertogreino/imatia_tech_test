package com.imatia.imatia_tech_test.service.impl;

import com.imatia.imatia_tech_test.controller.request.OrderTrackingRequest;
import com.imatia.imatia_tech_test.dto.OrderTrackingDTO;
import com.imatia.imatia_tech_test.model.OrderListTrackingMapper;
import com.imatia.imatia_tech_test.repository.OrderTrackingRepository;
import com.imatia.imatia_tech_test.service.OrderTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

    private final OrderTrackingRepository orderTrackingRepository;
    private final OrderListTrackingMapper orderListTrackingMapper;

    @Autowired
    public OrderTrackingServiceImpl(OrderTrackingRepository orderTrackingRepository,
                                    OrderListTrackingMapper orderListTrackingMapper) {
        this.orderTrackingRepository = orderTrackingRepository;
        this.orderListTrackingMapper = orderListTrackingMapper;
    }

    @Override
    public List<OrderTrackingDTO> saveOrderTrackingList(List<OrderTrackingRequest> orderTrackingRequestList) {
        List<OrderTrackingDTO> orderTrackingDTOS =  orderTrackingRequestList.stream().map(OrderTrackingRequest -> {
            OrderTrackingDTO orderTrackingDTO = new OrderTrackingDTO();
            orderTrackingDTO.setOrderId(OrderTrackingRequest.getOrderId());
            orderTrackingDTO.setStatusId(OrderTrackingRequest.getTrackingStatusId());
            orderTrackingDTO.setChangeStatusDate(OrderTrackingRequest.getChangeStatusDate());
            return orderTrackingDTO;
        }).collect(Collectors.toList());

        orderTrackingRepository.saveAll(orderListTrackingMapper.orderTrackingDTOListToOrderTrackingRegistryList(orderTrackingDTOS));

        return orderTrackingDTOS;
    }
}
