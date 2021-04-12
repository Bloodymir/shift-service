package com.vladimiro.shift.consumer.service;

import com.vladimiro.shift.consumer.domain.ShiftEntity;

import java.util.List;

public interface ShiftService {
    void persist(List<ShiftEntity> shiftEntities);
}
