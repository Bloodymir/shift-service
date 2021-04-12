package com.vladimiro.shift.consumer.service;

import com.vladimiro.shift.consumer.domain.ShiftEntity;
import com.vladimiro.shift.consumer.repository.ShiftRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;

    public ShiftServiceImpl(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    @Override
    @Transactional
    public void persist(List<ShiftEntity> shiftEntities) {
        shiftRepository.saveAll(shiftEntities);
    }
}
