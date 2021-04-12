package com.vladimiro.shift.provider.resource;

import com.vladimiro.shift.provider.resource.response.Shift;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Resource representing shifts
 */
@RequestMapping("/api/shifts")
public interface ShiftResourceApi {

    /**
     * Finds shifts from previous week based on provided numberOfShifts
     * @param numberOfShifts must be greater than 0
     * @return shifts and response status 200 if everything is fine
     */
    @GetMapping
    ResponseEntity<List<Shift>> findShiftData(@RequestParam @Valid @Min(1) Integer numberOfShifts);
}
