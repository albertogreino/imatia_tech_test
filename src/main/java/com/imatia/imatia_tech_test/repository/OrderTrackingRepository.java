package com.imatia.imatia_tech_test.repository;

import com.imatia.imatia_tech_test.model.OrderTrackingRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTrackingRepository extends JpaRepository<OrderTrackingRegistry, Integer> {

}
