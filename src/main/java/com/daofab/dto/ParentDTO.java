package com.daofab.dto;

import com.daofab.domain.Parent;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ParentDTO {
    private List<Parent> data;
}
