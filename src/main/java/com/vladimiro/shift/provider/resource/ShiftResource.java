package com.vladimiro.shift.provider.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RequestMapping("/api/shifts")
@RestController
public class ShiftResource {

    private final ShiftService shiftService;

    public ShiftResource(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping
    public ResponseEntity<List<Shift>> findShiftData(@RequestParam @Valid @Min(1) Integer numberOfShifts) {
        return ResponseEntity.ok(shiftService.getShifts(numberOfShifts));
    }
}
