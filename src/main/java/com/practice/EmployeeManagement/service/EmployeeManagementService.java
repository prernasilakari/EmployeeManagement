package com.practice.EmployeeManagement.service;

import com.practice.EmployeeManagement.VO.EmployeeManagementVO;

import java.util.List;

public interface EmployeeManagementService {

    List<EmployeeManagementVO> getAllEmp();

    EmployeeManagementVO createEmp(EmployeeManagementVO employeeManagementVO);

    EmployeeManagementVO getById(int id) throws Exception;

    EmployeeManagementVO getByName(String name) throws Exception;

    void deleteByEmployeeId(int id) throws Exception;

    EmployeeManagementVO updateEmpbyId(EmployeeManagementVO employeeManagementVO, int id) throws Exception;
}
