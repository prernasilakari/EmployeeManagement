package com.practice.EmployeeManagement;

import com.practice.EmployeeManagement.VO.EmployeeManagementVO;
import com.practice.EmployeeManagement.model.EmployeeManagementModel;
import com.practice.EmployeeManagement.repository.EmployeeManagementRepository;
import com.practice.EmployeeManagement.service.EmployeeManagementServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmployeeManagementServiceImpl employeeManagementService;

    @MockBean
    private EmployeeManagementRepository employeeManagementRepository;

    @Test
    public void getEmpTest() {
        when(employeeManagementRepository.findAll()).thenReturn(Stream.of(
                new EmployeeManagementModel(1, "xyz", 20, null, null),
                new EmployeeManagementModel(1, "xyz", 20, null, null))
                .collect(Collectors.toList()));
        assertEquals(2, employeeManagementService.getAllEmp().size());

    }


}