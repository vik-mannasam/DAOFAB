package com.daofab.domain;

import lombok.Data;

@Data
public class Child {
    private Integer id;
    private Integer parentId;
    private Integer paidAmount;
}
