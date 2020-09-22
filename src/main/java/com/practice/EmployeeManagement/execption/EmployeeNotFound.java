package com.practice.EmployeeManagement.execption;

public class EmployeeNotFound extends Exception {
    public EmployeeNotFound(int id) {
        super(String.format("Employee Not Found of id %d ", id));
    }

    public EmployeeNotFound(String name) {
        super(String.format("Employee Not Found of name %s ", name));
    }
}