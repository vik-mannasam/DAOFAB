package com.daofab.dto;

import lombok.Data;

@Data
public class ChildParentDTO {

    private Integer id;
    private String sender;
    private String receiver;
    private Integer totalAmount;
    private Integer paidAmount;

}
