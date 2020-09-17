package com.practice.EmployeeManagement.repository;

import com.practice.EmployeeManagement.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressModel, Integer> {
}
