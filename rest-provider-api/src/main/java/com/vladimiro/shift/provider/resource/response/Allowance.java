package com.vladimiro.shift.provider.resource.response;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class Allowance {

    @Min(1)
    @Max(50000)
    private Long id;
    private String name;
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private Float value;
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private Float cost;
}
