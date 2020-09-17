package com.practice.EmployeeManagement.service;

import com.practice.EmployeeManagement.VO.EmployeeManagementVO;

import java.util.List;

public interface EmployeeManagementServiceInterface {

    public List<EmployeeManagementVO> getAllEmp();

    public void createEmp(EmployeeManagementVO employeeManagementVO);

    public EmployeeManagementVO getById(int id);

}
