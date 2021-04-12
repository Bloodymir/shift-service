package com.vladimiro.shift.consumer.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Table(name = "award_interpretation")
@Data
public class AwardInterpretationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float units;
    @Column(name = "award_date")
    private LocalDate date;
    private String exportName;
    private String secondaryExportName;
    private Boolean ordinaryHours;
    private Float cost;
    @Column(name = "award_from")
    private ZonedDateTime from;
    @Column(name = "award_to")
    private ZonedDateTime to;

    private Integer shiftId;
    private LocalDate shiftDate;
    private Integer shiftTimesheetId;


}
