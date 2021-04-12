package com.vladimiro.shift.consumer.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Table(name = "break")
@Data
public class BreakEntity {

    @Id
    private Integer id;
    private ZonedDateTime start;
    private ZonedDateTime finish;
    @Column(name = "break_length")
    private Integer length;
    private Boolean paid;

    private Integer shiftId;
    private LocalDate shiftDate;
    private Integer shiftTimesheetId;
}
