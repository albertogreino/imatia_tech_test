package com.imatia.imatia_tech_test.repository;

import com.imatia.imatia_tech_test.model.OrderTrackingRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTrackingRepository extends JpaRepository<OrderTrackingRegistry, Integer> {
    @Query(value = "SELECT * FROM ORDER_TRACKING_REGISTRY WHERE ORDER_ID = :orderId ORDER BY CHANGE_STATUS_DATE DESC", nativeQuery = true)
    List<OrderTrackingRegistry> getOrderTrackingByOrderIdOrderedByDate(@Param("orderId") Integer orderId);
}
