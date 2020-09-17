package com.practice.EmployeeManagement.execption;

public class EmployeeNotFound extends Exception {
    public EmployeeNotFound(Long id) {
        super(String.format("Employee Not Found of id %d ", id));
    }
}