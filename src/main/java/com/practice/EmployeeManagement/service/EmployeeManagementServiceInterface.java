package com.practice.EmployeeManagement.service;

import com.practice.EmployeeManagement.VO.EmployeeManagementVO;

import java.util.List;

public interface EmployeeManagementServiceInterface {

    List<EmployeeManagementVO> getAllEmp();

    void createEmp(EmployeeManagementVO employeeManagementVO);

    EmployeeManagementVO getById(int id) throws Exception;

}
