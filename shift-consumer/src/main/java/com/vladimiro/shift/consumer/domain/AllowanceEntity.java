package com.vladimiro.shift.consumer.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Table(name = "allowance")
@Entity
public class AllowanceEntity {

    @Id
    private Long id;
    private String name;
    @Column(name = "allowance_value")
    private Float value;
    private Float cost;

    private Integer shiftId;
    private LocalDate shiftDate;
    private Integer shiftTimesheetId;
}
