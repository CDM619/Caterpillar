package com.caterpillar.smartrental.repository;

import com.caterpillar.smartrental.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperatorRepository extends JpaRepository<Operator, Long> {

    Optional<Operator> findByEmployeeId(String employeeId);
}