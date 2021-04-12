package com.vladimiro.shift.provider.resource;


import com.vladimiro.shift.provider.resource.response.Shift;

import java.util.List;

public interface ShiftService {

    List<Shift> getShifts(Integer integer);
}
