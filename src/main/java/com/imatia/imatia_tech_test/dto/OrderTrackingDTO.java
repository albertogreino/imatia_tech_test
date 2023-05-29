package com.imatia.imatia_tech_test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrderTrackingDTO {
    private int orderId;
    private int statusId;
    private Date changeStatusDate;
}
