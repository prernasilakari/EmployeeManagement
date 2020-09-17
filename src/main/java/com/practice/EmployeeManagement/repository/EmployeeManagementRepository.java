package com.practice.EmployeeManagement.repository;

import com.practice.EmployeeManagement.model.EmployeeManagementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeManagementRepository extends JpaRepository<EmployeeManagementModel, Integer> {
    EmployeeManagementModel findById(int employeeId);
}
