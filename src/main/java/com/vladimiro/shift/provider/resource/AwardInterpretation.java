package com.vladimiro.shift.provider.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class AwardInterpretation {
    @DecimalMin("0.1")
    private Float units;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    @Past
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
    private Long from;
    private Long to;

    public Float getUnits() {
        return units;
    }

    public void setUnits(Float units) {
        this.units = units;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getExportName() {
        return exportName;
    }

    public void setExportName(String exportName) {
        this.exportName = exportName;
    }

    public String getSecondaryExportName() {
        return secondaryExportName;
    }

    public void setSecondaryExportName(String secondaryExportName) {
        this.secondaryExportName = secondaryExportName;
    }

    public Boolean getOrdinaryHours() {
        return ordinaryHours;
    }

    public void setOrdinaryHours(Boolean ordinaryHours) {
        this.ordinaryHours = ordinaryHours;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
