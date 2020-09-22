package com.practice.EmployeeManagement.controller;

import com.practice.EmployeeManagement.VO.EmployeeManagementVO;
import com.practice.EmployeeManagement.execption.EmployeeNotFound;
import com.practice.EmployeeManagement.service.EmployeeManagementServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<EmployeeManagementVO>> getAllEmployee() {
        List<EmployeeManagementVO> employeeManagementVOS = employeeManagementService.getAllEmp();
        return new ResponseEntity<>(employeeManagementVOS, HttpStatus.OK);
    }

    /**
     * This method will save a new employee
     *
     * @param employeeManagementVO
     */
    @PostMapping("/addEmp")
    public ResponseEntity<EmployeeManagementVO> addEmp(@RequestBody EmployeeManagementVO employeeManagementVO) {
        employeeManagementService.createEmp(employeeManagementVO);
        return new ResponseEntity<>(employeeManagementVO, HttpStatus.CREATED);
    }

    /**
     * This method is used to get the employee details by their id
     *
     * @param id
     * @return
     */
    @GetMapping("getById/{id}")
    public ResponseEntity<EmployeeManagementVO> getEmpById(@PathVariable int id) throws EmployeeNotFound {
        EmployeeManagementVO employeeManagementVO = employeeManagementService.getById(id);
        return new ResponseEntity<>(employeeManagementVO, HttpStatus.OK);
    }

    /**
     * Used to get employee by name
     *
     * @param name
     * @return
     * @throws Exception
     */
    @GetMapping("getByName/{name}")
    public ResponseEntity<EmployeeManagementVO> getEmpByName(@PathVariable String name) throws EmployeeNotFound {
        EmployeeManagementVO employeeManagementVO = employeeManagementService.getByName(name);
        return new ResponseEntity<>(employeeManagementVO, HttpStatus.OK);
    }

    /**
     * Used to delete employee by id
     *
     * @param id
     * @throws Exception
     */
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable int id) throws EmployeeNotFound {
        employeeManagementService.deleteByEmployeeId(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Used to update employee
     *
     * @param employeeManagementVO
     */
    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<EmployeeManagementVO> updateEmpById(@RequestBody EmployeeManagementVO employeeManagementVO, @PathVariable int id) throws EmployeeNotFound {
        EmployeeManagementVO employeeManagementVO1 = employeeManagementService.updateEmpbyId(employeeManagementVO, id);
        return new ResponseEntity<>(employeeManagementVO1, HttpStatus.OK);

    }
}
