package com.imatia.imatia_tech_test.model;

import com.imatia.imatia_tech_test.dto.OrderTrackingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderListTrackingMapper {

    List<OrderTrackingDTO> orderTrackingRegistryListToOrderTrackingDTOList(List<OrderTrackingRegistry> orderTrackingRegistryList);

    @Mapping(source = "newStatusId", target = "statusId")
    OrderTrackingDTO orderTrackingRegistryListToOrderTrackingDTO(OrderTrackingRegistry orderTrackingRegistry);

    List<OrderTrackingRegistry> orderTrackingDTOListToOrderTrackingRegistryList(List<OrderTrackingDTO> orderTrackingDTOList);

    @Mapping(source = "statusId", target = "newStatusId")
    OrderTrackingRegistry orderTrackingDTOListToOrderTrackingRegistry(OrderTrackingDTO orderTrackingDTO);
}
