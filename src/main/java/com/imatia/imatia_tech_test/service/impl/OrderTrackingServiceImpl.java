package com.imatia.imatia_tech_test.service.impl;

import com.imatia.imatia_tech_test.controller.request.OrderTrackingRequest;
import com.imatia.imatia_tech_test.dto.OrderTrackingDTO;
import com.imatia.imatia_tech_test.model.OrderListTrackingMapper;
import com.imatia.imatia_tech_test.model.OrderTrackingRegistry;
import com.imatia.imatia_tech_test.repository.OrderTrackingRepository;
import com.imatia.imatia_tech_test.service.OrderTrackingService;
import com.imatia.imatia_tech_test.stateMachine.StateTransitionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

    private final OrderTrackingRepository repository;
    private final OrderListTrackingMapper mapper;

    @Autowired
    public OrderTrackingServiceImpl(OrderTrackingRepository orderTrackingRepository,
                                    OrderListTrackingMapper orderListTrackingMapper) {
        this.repository = orderTrackingRepository;
        this.mapper = orderListTrackingMapper;
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

        validateStatusTransition(orderTrackingDTOS);

        repository.saveAll(mapper.orderTrackingDTOListToOrderTrackingRegistryList(orderTrackingDTOS));

        return orderTrackingDTOS;
    }

    private void validateStatusTransition(List<OrderTrackingDTO> orderTrackingDTOList) {
        orderTrackingDTOList.forEach(orderTrackingDTO -> {
            if (!validateSingleStatusTransition(orderTrackingDTO)) {
                throw new IllegalArgumentException("Invalid status transition");
            }
        });
    }

    private boolean validateSingleStatusTransition(OrderTrackingDTO orderTrackingDTO) {
        List<OrderTrackingRegistry> oldOrders = repository.getOrderTrackingByOrderIdOrderedByDate(orderTrackingDTO.getOrderId());

        if (oldOrders.isEmpty()) {
            return true;
        }

        return StateTransitionValidator.isValidTransition(oldOrders.get(0).getNewStatusId(), orderTrackingDTO.getStatusId());
    }
}
