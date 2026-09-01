package com.caterpillar.smartrental.repository;

import com.caterpillar.smartrental.model.Equipment;
import com.caterpillar.smartrental.model.EquipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findBySerialNumber(String serialNumber);

    List<Equipment> findByStatus(EquipmentStatus status);
}