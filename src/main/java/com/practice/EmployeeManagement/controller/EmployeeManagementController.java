package com.practice.EmployeeManagement.controller;

import com.practice.EmployeeManagement.VO.EmployeeManagementVO;
import com.practice.EmployeeManagement.service.EmployeeManagementServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmployeeManagementController {
    @Autowired
    private EmployeeManagementServiceImpl employeeManagementService;

    /**
     * This method will return the list of all the employee
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<EmployeeManagementVO> getAllEmployee() {
        return employeeManagementService.getAllEmp();
    }

    /**
     * This method will save a new employee
     *
     * @param employeeManagementVO
     */
    @PostMapping("/addEmp")
    public void addEmp(@RequestBody EmployeeManagementVO employeeManagementVO) {
        employeeManagementService.createEmp(employeeManagementVO);
    }

    /**
     * This method is used to get the employee details by their id
     *
     * @param id
     * @return
     */
    @GetMapping("getById/{id}")
    public EmployeeManagementVO getEmpById(@PathVariable int id) throws Exception {
        return employeeManagementService.getById(id);
    }

    /**
     * Used to get employee by name
     *
     * @param name
     * @return
     * @throws Exception
     */
    @GetMapping("getByName/{name}")
    public EmployeeManagementVO getEmpByName(@PathVariable String name) throws Exception {
        return employeeManagementService.getByName(name);
    }

    /**
     * Used to delete employee by id
     *
     * @param id
     * @throws Exception
     */
    @DeleteMapping("deleteById/{id}")
    public void deleteEmpById(@PathVariable int id) throws Exception {
        employeeManagementService.deleteById(id);
    }

    /**
     * Used to update employee
     *
     * @param employeeManagementVO
     */
    @PutMapping("/updateEmp/{id}")
    public void updateEmpById(@RequestBody EmployeeManagementVO employeeManagementVO, @PathVariable int id) throws Exception {
        employeeManagementService.updateEmpbyId(employeeManagementVO, id);

    }
}
