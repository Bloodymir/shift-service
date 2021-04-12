package com.vladimiro.shift.consumer.mapper;

import com.vladimiro.shift.consumer.domain.AllowanceEntity;
import com.vladimiro.shift.consumer.domain.AwardInterpretationEntity;
import com.vladimiro.shift.consumer.domain.BreakEntity;
import com.vladimiro.shift.consumer.domain.ShiftEntity;
import com.vladimiro.shift.provider.resource.response.Shift;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface ShiftMapper {

    ShiftEntity mapToEntity(Shift shift, @Context ShiftParams shiftParams);

    @AfterMapping
    default void afterMappingAllowance(@MappingTarget AllowanceEntity allowance, @Context ShiftParams shiftParams) {
        allowance.setShiftId(shiftParams.getShiftId());
        allowance.setShiftDate(shiftParams.getShiftDate());
        allowance.setShiftTimesheetId(shiftParams.getTimesheetId());
    }

    @AfterMapping
    default void afterMappingBreak(@MappingTarget BreakEntity breakEntity, @Context ShiftParams shiftParams) {
        breakEntity.setShiftId(shiftParams.getShiftId());
        breakEntity.setShiftDate(shiftParams.getShiftDate());
        breakEntity.setShiftTimesheetId(shiftParams.getTimesheetId());
    }

    @AfterMapping
    default void afterMappingAwardInterpretation(@MappingTarget AwardInterpretationEntity awardInterpretationEntity,
                                                 @Context ShiftParams shiftParams) {
        awardInterpretationEntity.setShiftId(shiftParams.getShiftId());
        awardInterpretationEntity.setShiftDate(shiftParams.getShiftDate());
        awardInterpretationEntity.setShiftTimesheetId(shiftParams.getTimesheetId());
    }


    default ZonedDateTime epochToZonedDateTimeEST(Instant epochLong) {
        if (epochLong == null) {
            return null;
        }

        return epochLong.atZone(ZoneId.of("America/New_York"));
    }
}
