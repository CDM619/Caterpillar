package com.caterpillar.smartrental.repository;

import com.caterpillar.smartrental.model.Equipment;
import com.caterpillar.smartrental.model.Operator;
import com.caterpillar.smartrental.model.UsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsageLogRepository extends JpaRepository<UsageLog, Long> {

    List<UsageLog> findByEquipment(Equipment equipment);

    List<UsageLog> findByOperator(Operator operator);

    @Query("""
            SELECT COALESCE(SUM(u.hoursUsed), 0)
            FROM UsageLog u
            WHERE u.equipment.id = :equipmentId
            """)
    Double getTotalUsageHoursByEquipmentId(
            @Param("equipmentId") Long equipmentId
    );
}