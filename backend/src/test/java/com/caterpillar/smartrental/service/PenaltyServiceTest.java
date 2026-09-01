package com.caterpillar.smartrental.service;

import com.caterpillar.smartrental.dto.PenaltyCalculationResult;
import com.caterpillar.smartrental.model.Equipment;
import com.caterpillar.smartrental.repository.UsageLogRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PenaltyServiceTest {

    private UsageLogRepository usageLogRepository;
    private PenaltyService penaltyService;
    private Equipment equipment;

    @BeforeEach
    void setUp() {
        usageLogRepository = mock(UsageLogRepository.class);
        penaltyService = new PenaltyService(usageLogRepository);

        equipment = new Equipment();
        equipment.setId(1L);
        equipment.setNormalDailyUsageHours(8.0);
        equipment.setMaximumRecommendedUsageHours(10000.0);
        equipment.setPenaltyPerExtraHour(new BigDecimal("500.00"));
    }

    @Test
    void shouldReturnZeroPenaltyForNormalUsage() {
        when(usageLogRepository.getTotalUsageHoursByEquipmentId(1L))
                .thenReturn(100.0);

        PenaltyCalculationResult result =
                penaltyService.calculatePenalty(equipment, 6.0);

        assertEquals(106.0, result.getTotalUsageHours());
        assertEquals(0.0, result.getExtraUsageHours());
        assertEquals(new BigDecimal("0.00"), result.getBasePenalty());
        assertEquals(1.0, result.getWearFactor());
        assertEquals(new BigDecimal("0.00"), result.getFinalPenalty());
    }

    @Test
    void shouldCalculatePenaltyForDailyOveruse() {
        when(usageLogRepository.getTotalUsageHoursByEquipmentId(1L))
                .thenReturn(100.0);

        PenaltyCalculationResult result =
                penaltyService.calculatePenalty(equipment, 11.0);

        assertEquals(111.0, result.getTotalUsageHours());
        assertEquals(3.0, result.getExtraUsageHours());
        assertEquals(new BigDecimal("1500.00"), result.getBasePenalty());
        assertEquals(1.0, result.getWearFactor());
        assertEquals(new BigDecimal("1500.00"), result.getFinalPenalty());
    }

    @Test
    void shouldIncreasePenaltyWhenUsageExceedsRecommendedLimit() {
        when(usageLogRepository.getTotalUsageHoursByEquipmentId(1L))
                .thenReturn(9997.0);

        PenaltyCalculationResult result =
                penaltyService.calculatePenalty(equipment, 11.0);

        assertEquals(10008.0, result.getTotalUsageHours());
        assertEquals(3.0, result.getExtraUsageHours());
        assertEquals(new BigDecimal("1500.00"), result.getBasePenalty());

        assertEquals(1.0008, result.getWearFactor(), 0.00001);

        assertEquals(
                new BigDecimal("1501.20"),
                result.getFinalPenalty()
        );
    }

    @Test
    void shouldHandleNoPreviousUsageLogs() {
        when(usageLogRepository.getTotalUsageHoursByEquipmentId(1L))
                .thenReturn(0.0);

        PenaltyCalculationResult result =
                penaltyService.calculatePenalty(equipment, 10.0);

        assertEquals(10.0, result.getTotalUsageHours());
        assertEquals(2.0, result.getExtraUsageHours());
        assertEquals(new BigDecimal("1000.00"), result.getBasePenalty());
        assertEquals(1.0, result.getWearFactor());
        assertEquals(new BigDecimal("1000.00"), result.getFinalPenalty());
    }
}