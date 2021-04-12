package com.vladimiro.shift.consumer.scheduled;

import com.vladimiro.shift.consumer.domain.ShiftEntity;
import com.vladimiro.shift.consumer.mapper.ShiftMapper;
import com.vladimiro.shift.consumer.mapper.ShiftParams;
import com.vladimiro.shift.consumer.service.ShiftService;
import com.vladimiro.shift.provider.resource.ShiftResourceApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class ShiftConsumerJob {

    private static final Logger logger = LogManager.getLogger(ShiftConsumerJob.class);

    private final ShiftResourceApi shiftResourceApi;
    private final ShiftMapper shiftMapper;
    private final ShiftService shiftService;

    public ShiftConsumerJob(ShiftResourceApi shiftResourceApi, ShiftMapper shiftMapper, ShiftService shiftService) {
        this.shiftResourceApi = shiftResourceApi;
        this.shiftMapper = shiftMapper;
        this.shiftService = shiftService;
    }

    @Scheduled(fixedDelay = 60000)
    public void consumeShifts() {
        logger.info("Job started");
        Optional.ofNullable(shiftResourceApi.findShiftData(1).getBody())
                .ifPresentOrElse(response -> {
                        List<ShiftEntity> shiftEntities = response.stream()
                                .map(shift -> shiftMapper.mapToEntity(shift, new ShiftParams(shift.getId(), shift.getTimesheetId(), shift.getDate())))
                                .collect(Collectors.toUnmodifiableList());
                        shiftService.persist(shiftEntities);
                                },
                                () -> logger.error("ShiftResourceApi::findShiftData returned null body"));
        logger.info("Job finished");
    }
}
