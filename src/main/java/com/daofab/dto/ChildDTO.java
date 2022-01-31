package com.daofab.dto;

import com.daofab.domain.Child;
import lombok.Data;

import java.util.List;

@Data
public class ChildDTO {
    private List<Child> data;
}
