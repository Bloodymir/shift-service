package com.vladimiro.shift.provider.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.vladimiro.shift.provider.resource.deserializer.DefaultInstantDeserializer;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;

@Data
public class Break {

    @Min(1)
    @Max(50000)
    private Integer id;

    @Min(1)
    @Max(50000)
    @JsonProperty("shift_id")
    private Integer shiftId;

    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant start;

    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant finish;
    @Min(0)
    @Max(1000)
    private Integer length;

    private Boolean paid;
}
