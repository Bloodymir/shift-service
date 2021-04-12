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
import java.time.Instant;
import java.time.LocalDate;

@Data
public class AwardInterpretation {
    @DecimalMin("0.1")
    private Float units;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty("export_name")
    private String exportName;

    @JsonProperty("secondary_export_name")
    private String secondaryExportName;

    @JsonProperty("ordinary_hours")
    private Boolean ordinaryHours;

    @DecimalMin("0.1")
    @DecimalMax("5.0")
    private Float cost;

    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant from;

    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant to;
}
