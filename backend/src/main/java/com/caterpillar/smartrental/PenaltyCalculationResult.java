package com.caterpillar.smartrental.dto;

import java.math.BigDecimal;

public class PenaltyCalculationResult {

    private Double totalUsageHours;
    private Double extraUsageHours;
    private BigDecimal basePenalty;
    private Double wearFactor;
    private BigDecimal finalPenalty;

    public PenaltyCalculationResult(
            Double totalUsageHours,
            Double extraUsageHours,
            BigDecimal basePenalty,
            Double wearFactor,
            BigDecimal finalPenalty
    ) {
        this.totalUsageHours = totalUsageHours;
        this.extraUsageHours = extraUsageHours;
        this.basePenalty = basePenalty;
        this.wearFactor = wearFactor;
        this.finalPenalty = finalPenalty;
    }

    public Double getTotalUsageHours() {
        return totalUsageHours;
    }

    public Double getExtraUsageHours() {
        return extraUsageHours;
    }

    public BigDecimal getBasePenalty() {
        return basePenalty;
    }

    public Double getWearFactor() {
        return wearFactor;
    }

    public BigDecimal getFinalPenalty() {
        return finalPenalty;
    }
}