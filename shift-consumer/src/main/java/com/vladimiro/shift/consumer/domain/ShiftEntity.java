package com.vladimiro.shift.consumer.domain;

import com.vladimiro.shift.provider.resource.response.Status;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "shift")
@Entity
@Data
public class ShiftEntity {
    @Id
    Integer id;
    Integer timesheetId;
    Integer userId;
    @Column(name = "shift_date")
    LocalDate date;

    ZonedDateTime start;
    ZonedDateTime finish;
    @Column(name = "break_start")
    ZonedDateTime breakStart;
    @Column(name = "break_finish")
    ZonedDateTime breakFinish;
    @Column(name = "approved_at")
    ZonedDateTime approvedAt;
    @Column(name = "updated_at")
    ZonedDateTime updatedAt;
    @Column(name = "last_costed_at")
    ZonedDateTime lastCostedAt;

    @Column(name = "break_length")
    Integer breakLength;
    Status status;

    String tag;
    Integer tagId;
    String subCostCentre;
    Float cost;

    Integer departmentId;
    String metadata;
    Integer recordId;
    Integer leaveRequestId;
    Integer approvedBy;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shiftId")
    List<BreakEntity> breaks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shiftId")
    List<AllowanceEntity> allowances = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shiftId")
    List<AwardInterpretationEntity> awardInterpretation = new ArrayList<>();

}
