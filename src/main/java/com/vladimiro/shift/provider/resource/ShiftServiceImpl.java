package com.vladimiro.shift.provider.resource;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {
    @Override
    public List<Shift> getShifts(Integer numberOfShifts) {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters();
        easyRandomParameters.setCollectionSizeRange(new EasyRandomParameters.Range<>(1, 2));
        EasyRandom easyRandom = new EasyRandom(easyRandomParameters);
        return Collections.singletonList(easyRandom.nextObject(Shift.class));
    }
}
