package com.vladimiro.shift.consumer.mapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class ShiftParams {

    private final Integer shiftId;
    private final Integer timesheetId;
    private final LocalDate shiftDate;
}
