package com.vladimiro.shift.provider.resource.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.vladimiro.shift.provider.resource.deserializer.DefaultInstantDeserializer;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
public class Shift {
    @Min(1)
    @Max(50000)
    private Integer id;

    @JsonProperty("timesheet_id")
    @Min(1)
    @Max(50000)
    private Integer timesheetId;

    @JsonProperty("user_id")
    @Min(1)
    @Max(50000)
    private Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant start;

    @JsonProperty("break_start")
    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant breakStart;

    @JsonProperty("break_finish")
    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant breakFinish;

    @JsonProperty("break_length")
    @Min(1)
    @Max(1000)
    private Integer breakLength;

    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant finish;

    private Status status;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant updatedAt;

    @JsonProperty("record_id")
    @Min(1)
    @Max(50000)
    private Integer recordId;

    @JsonProperty("last_costed_at")
    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant lastCostedAt;

    private String tag;

    @JsonProperty("tag_id")
    @Min(1)
    @Max(50000)
    private Integer tagId;

    @JsonProperty("sub_cost_centre")
    private String subCostCentre;

    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private Float cost;

    @JsonProperty("department_id")
    @Min(1)
    @Max(50000)
    private Integer departmentId;

    private String metadata;

    @Min(1)
    @Max(50000)
    @JsonProperty("leave_request_id")
    private Integer leaveRequestId;

    @Min(1)
    @Max(50000)
    @JsonProperty("approved_by")
    private Integer approvedBy;

    @JsonProperty("approved_at")
    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant approvedAt;

    private List<Break> breaks;
    private List<Allowance> allowances;
    @JsonProperty("award_interpretation")
    private List<AwardInterpretation> awardInterpretation;
    private List<Note> notes;
}
