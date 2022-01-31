package com.daofab.domain;

import lombok.Data;

@Data
public class Parent {
    private Integer id;
    private String sender;
    private String receiver;
    private Integer totalAmount;
    private Integer paidAmount;
}
