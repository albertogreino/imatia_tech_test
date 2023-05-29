package com.imatia.imatia_tech_test.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class OrderTrackingRegistryPK implements Serializable {
    private int orderId;
    private Date changeStatusDate;
}
