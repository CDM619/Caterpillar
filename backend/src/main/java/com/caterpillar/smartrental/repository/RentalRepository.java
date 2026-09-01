package com.caterpillar.smartrental.repository;

import com.caterpillar.smartrental.model.Equipment;
import com.caterpillar.smartrental.model.Operator;
import com.caterpillar.smartrental.model.Rental;
import com.caterpillar.smartrental.model.RentalStatus;
import com.caterpillar.smartrental.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByEquipment(Equipment equipment);

    List<Rental> findBySite(Site site);

    List<Rental> findByOperator(Operator operator);

    List<Rental> findByStatus(RentalStatus status);
}