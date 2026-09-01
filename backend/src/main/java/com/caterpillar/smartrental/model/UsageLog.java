package com.caterpillar.smartrental.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "usage_logs")
public class UsageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Equipment equipment;

    @ManyToOne
    private Operator operator;

    @Column(nullable = false)
    private LocalDateTime usageStart;

    private LocalDateTime usageEnd;

    private Double hoursUsed;

    private String notes;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public LocalDateTime getUsageStart() {
        return usageStart;
    }

    public void setUsageStart(LocalDateTime usageStart) {
        this.usageStart = usageStart;
    }

    public LocalDateTime getUsageEnd() {
        return usageEnd;
    }

    public void setUsageEnd(LocalDateTime usageEnd) {
        this.usageEnd = usageEnd;
    }

    public Double getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(Double hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}