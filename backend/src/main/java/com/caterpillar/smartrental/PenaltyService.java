package com.caterpillar.smartrental.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.caterpillar.smartrental.dto.PenaltyCalculationResult;
import com.caterpillar.smartrental.model.Equipment;
import com.caterpillar.smartrental.repository.UsageLogRepository;

@Service
public class PenaltyService {

    private final UsageLogRepository usageLogRepository;

    public PenaltyService(UsageLogRepository usageLogRepository) {
        this.usageLogRepository = usageLogRepository;
    }

    public PenaltyCalculationResult calculatePenalty(
            Equipment equipment,
            Double currentUsageHours
    ) {

        if (equipment == null) {
            throw new IllegalArgumentException("Equipment must not be null");
        }

        if (equipment.getId() == null) {
            throw new IllegalArgumentException("Equipment must have an ID");
        }

        if (currentUsageHours == null || currentUsageHours < 0) {
            throw new IllegalArgumentException(
                    "Current usage hours must be zero or greater"
            );
        }

        if (equipment.getNormalDailyUsageHours() == null
                || equipment.getNormalDailyUsageHours() <= 0) {
            throw new IllegalArgumentException(
                    "Normal daily usage hours must be greater than zero"
            );
        }

        if (equipment.getMaximumRecommendedUsageHours() == null
                || equipment.getMaximumRecommendedUsageHours() <= 0) {
            throw new IllegalArgumentException(
                    "Maximum recommended usage hours must be greater than zero"
            );
        }

        if (equipment.getPenaltyPerExtraHour() == null
                || equipment.getPenaltyPerExtraHour().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Penalty per extra hour must be zero or greater"
            );
        }

        Double previousTotalUsage =
                usageLogRepository.getTotalUsageHoursByEquipmentId(
                        equipment.getId()
                );

        if (previousTotalUsage == null) {
            previousTotalUsage = 0.0;
        }

        Double totalUsageHours = previousTotalUsage + currentUsageHours;

        Double extraUsageHours = Math.max(
                0.0,
                currentUsageHours - equipment.getNormalDailyUsageHours()
        );

        BigDecimal basePenalty = equipment.getPenaltyPerExtraHour()
                .multiply(BigDecimal.valueOf(extraUsageHours));

        Double wearFactor = 1.0;

        if (totalUsageHours > equipment.getMaximumRecommendedUsageHours()) {
            wearFactor = totalUsageHours
                    / equipment.getMaximumRecommendedUsageHours();
        }

        BigDecimal roundedBasePenalty = basePenalty
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal finalPenalty = basePenalty
                .multiply(BigDecimal.valueOf(wearFactor))
                .setScale(2, RoundingMode.HALF_UP);

        return new PenaltyCalculationResult(
                totalUsageHours,
                extraUsageHours,
                roundedBasePenalty,
                wearFactor,
                finalPenalty
        );
    }
}