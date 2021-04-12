package com.vladimiro.shift.provider.resource;

import com.vladimiro.shift.provider.resource.response.Shift;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generates shifts for the previous week
 */
@Service
public class GenerateShiftServiceImpl implements ShiftService {

    /**
     * Uses {@link EasyRandomParameters} to generate requested number of shifts
     *
     * @param numberOfShifts size of generated response
     * @return list of shifts
     */
    @Override
    public List<Shift> getShifts(Integer numberOfShifts) {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters();

        easyRandomParameters.dateRange(LocalDate.now().minusWeeks(1).with(DayOfWeek.MONDAY),
                LocalDate.now().minusWeeks(1).with(DayOfWeek.SUNDAY));
        easyRandomParameters.setCollectionSizeRange(new EasyRandomParameters.Range<>(1, 2));
        EasyRandom easyRandom = new EasyRandom(easyRandomParameters);

        return easyRandom.objects(Shift.class,numberOfShifts).collect(Collectors.toUnmodifiableList());
    }
}
