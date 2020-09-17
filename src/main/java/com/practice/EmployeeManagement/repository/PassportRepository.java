package com.practice.EmployeeManagement.repository;
import com.practice.EmployeeManagement.model.PassportModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<PassportModel, Integer> {
}
