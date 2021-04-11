package com.vladimiro.shift.provider.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Shift {
    @Min(1)
    Integer id;
    @JsonProperty("timesheet_id")
    @Min(1)
    Integer timesheetId;
    @JsonProperty("user_id")
    @Min(1)
    Integer userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    LocalDate date;
    Long start;
    @JsonProperty("break_start")
    Long breakStart;
    @JsonProperty("break_finish")
    Long breakFinish;
    @JsonProperty("break_length")
    @Min(1)
    Integer breakLength;
    Long finish;
    Status status;

    @JsonProperty("updated_at")
    Long updatedAt;
    @JsonProperty("record_id")
    Integer recordId;
    @JsonProperty("last_costed_at")
    Long lastCostedAt;

    String tag;
    @JsonProperty("tag_id")
    Integer tagId;
    @JsonProperty("sub_cost_centre")
    String subCostCentre;
    Float cost;

    @JsonProperty("department_id")
    @Min(1)
    Integer departmentId;
    String metadata;
    @JsonProperty("leave_request_id")
    Integer leaveRequestId;
    @JsonProperty("approved_by")
    Integer approvedBy;

    @JsonProperty("approved_at")
    LocalDateTime approvedAt;

    List<Break> breaks;
    List<Allowance> allowances;
    @JsonProperty("award_interpretation")
    List<AwardInterpretation> awardInterpretation;
    List<Note> notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(Integer timesheetId) {
        this.timesheetId = timesheetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getBreakStart() {
        return breakStart;
    }

    public void setBreakStart(Long breakStart) {
        this.breakStart = breakStart;
    }

    public Long getBreakFinish() {
        return breakFinish;
    }

    public void setBreakFinish(Long breakFinish) {
        this.breakFinish = breakFinish;
    }

    public Integer getBreakLength() {
        return breakLength;
    }

    public void setBreakLength(Integer breakLength) {
        this.breakLength = breakLength;
    }

    public Long getFinish() {
        return finish;
    }

    public void setFinish(Long finish) {
        this.finish = finish;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Long getLastCostedAt() {
        return lastCostedAt;
    }

    public void setLastCostedAt(Long lastCostedAt) {
        this.lastCostedAt = lastCostedAt;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getSubCostCentre() {
        return subCostCentre;
    }

    public void setSubCostCentre(String subCostCentre) {
        this.subCostCentre = subCostCentre;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Integer getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(Integer leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }

    public List<Break> getBreaks() {
        return breaks;
    }

    public void setBreaks(List<Break> breaks) {
        this.breaks = breaks;
    }

    public List<Allowance> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<Allowance> allowances) {
        this.allowances = allowances;
    }

    public List<AwardInterpretation> getAwardInterpretation() {
        return awardInterpretation;
    }

    public void setAwardInterpretation(List<AwardInterpretation> awardInterpretation) {
        this.awardInterpretation = awardInterpretation;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
