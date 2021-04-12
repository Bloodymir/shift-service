package com.vladimiro.shift.provider.resource;

import com.vladimiro.shift.provider.resource.response.Shift;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring rest controller which implements {@link ShiftResourceApi}
 */
@RestController
public class ShiftResource implements ShiftResourceApi {

    private final ShiftService shiftService;

    public ShiftResource(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Shift>> findShiftData(Integer numberOfShifts) {
        return ResponseEntity.ok(shiftService.getShifts(numberOfShifts));
    }
}
