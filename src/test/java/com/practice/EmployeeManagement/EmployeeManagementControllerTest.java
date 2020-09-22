package com.practice.EmployeeManagement;


import com.practice.EmployeeManagement.VO.AddressVO;
import com.practice.EmployeeManagement.VO.EmployeeManagementVO;
import com.practice.EmployeeManagement.VO.PassportVO;
import com.practice.EmployeeManagement.controller.EmployeeManagementController;
import com.practice.EmployeeManagement.model.EmployeeManagementModel;
import com.practice.EmployeeManagement.repository.EmployeeManagementRepository;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeManagementControllerTest {
    @Autowired
    private EmployeeManagementController employeeManagementController;

    @MockBean
    private EmployeeManagementRepository employeeManagementRepository;

    @Test
    public void findAllEmpTest() {
        List<EmployeeManagementModel> employeeManagementModels = new ArrayList<>();
        employeeManagementModels.add(new EmployeeManagementModel(1, "xyz", 20, null, null));
        employeeManagementModels.add(new EmployeeManagementModel(2, "abc", 30, null, null));
        when(employeeManagementRepository.findAll()).thenReturn(employeeManagementModels);
        assertEquals(HttpStatus.OK, employeeManagementController.getAllEmployee().getStatusCode());
    }

    @Test
    public void addEmpTest() {
        PassportVO passportVO = new PassportVO(1, "ab");
        AddressVO addressVO = new AddressVO(1, "bhopalllllll");
        List<AddressVO> addressVOList = new ArrayList<>();
        addressVOList.add(addressVO);
        EmployeeManagementVO employeeManagementVO = new EmployeeManagementVO(1, "xyz", 66, addressVOList, passportVO);
        EmployeeManagementModel employeeManagementModel = new DozerBeanMapper().map(employeeManagementVO, EmployeeManagementModel.class);
        when(employeeManagementRepository.save(employeeManagementModel)).thenReturn(employeeManagementModel);
        assertEquals(HttpStatus.CREATED, employeeManagementController.addEmp(employeeManagementVO).getStatusCode());
    }

    @Test
    public void getByIdTest() throws Exception {
        int id = 1;
        EmployeeManagementModel employeeManagementModel = new EmployeeManagementModel(1, "xyz", 66, null, null);
        when(employeeManagementRepository.findByEmployeeId(id)).thenReturn(employeeManagementModel);
        assertEquals(HttpStatus.OK, employeeManagementController.getEmpById(id).getStatusCode());
    }

    @Test
    public void getByNameTest() throws Exception {
        String name = "prerna";
        EmployeeManagementModel employeeManagementModel = new EmployeeManagementModel(1, "xyz", 66, null, null);
        when(employeeManagementRepository.findByEmployeeName(name)).thenReturn(employeeManagementModel);
        assertEquals(HttpStatus.OK, employeeManagementController.getEmpByName(name).getStatusCode());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        int id = 1;
        EmployeeManagementModel employeeManagementModel = new EmployeeManagementModel(1, "xyz", 66, null, null);
        when(employeeManagementRepository.findByEmployeeId(id)).thenReturn(employeeManagementModel);
        assertEquals(HttpStatus.NOT_FOUND, employeeManagementController.deleteEmpById(id).getStatusCode());
    }

}


