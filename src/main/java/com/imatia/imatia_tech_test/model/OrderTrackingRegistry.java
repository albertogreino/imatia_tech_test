package com.imatia.imatia_tech_test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@IdClass(OrderTrackingRegistryPK.class)
@Table(name = "ORDER_TRACKING_REGISTRY")
public class OrderTrackingRegistry {
    @Id
    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "OLD_STATUS_ID")
    private int prevStatusId;

    @Column(name = "NEW_STATUS_ID")
    private int newStatusId;

    @Id
    @Column(name = "CHANGE_STATUS_DATE")
    private Date changeStatusDate;
}
