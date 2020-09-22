package com.practice.EmployeeManagement;

import com.practice.EmployeeManagement.VO.AddressVO;
import com.practice.EmployeeManagement.VO.EmployeeManagementVO;
import com.practice.EmployeeManagement.VO.PassportVO;
import com.practice.EmployeeManagement.execption.EmployeeNotFound;
import com.practice.EmployeeManagement.model.AddressModel;
import com.practice.EmployeeManagement.model.EmployeeManagementModel;
import com.practice.EmployeeManagement.model.PassportModel;
import com.practice.EmployeeManagement.repository.EmployeeManagementRepository;
import com.practice.EmployeeManagement.service.EmployeeManagementServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeManagementApplicationTests {

    @Autowired
    private EmployeeManagementServiceImpl employeeManagementService;

    @MockBean
    private EmployeeManagementRepository employeeManagementRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Test
    public void getAllEmpTest() {
        List<EmployeeManagementModel> employeeManagementModels = new ArrayList<>();
        PassportModel passportM1 = new PassportModel(1, "ab");
        AddressModel addressM1 = new AddressModel(1, "bhopalllllll");
        List<AddressModel> addressModelList1 = new ArrayList<>();
        addressModelList1.add(addressM1);

        PassportModel passportM2 = new PassportModel(2, "xy");
        AddressModel addressM2 = new AddressModel(2, "pune");
        List<AddressModel> addressModelList2 = new ArrayList<>();
        addressModelList2.add(addressM2);

        employeeManagementModels.add(new EmployeeManagementModel(1, "xyz", 20, addressModelList1, passportM1));
        employeeManagementModels.add(new EmployeeManagementModel(2, "abc", 30, addressModelList2, passportM2));
        /**
         * checking size
         */
        when(employeeManagementRepository.findAll()).thenReturn(employeeManagementModels);
        assertEquals(2, employeeManagementService.getAllEmp().size());
        /**
         * check for null
         */
        List<EmployeeManagementVO> employeeManagementVOS = employeeManagementService.getAllEmp();
        assertNotNull(employeeManagementVOS);

        /**
         * checking values
         */
        PassportVO passportVO = new PassportVO(1, "ab");
        PassportVO passportVO1 = new PassportVO(2, "xy");
        AddressVO addressVO = new AddressVO(1, "bhopalllllll");
        List<AddressVO> addressVOList = new ArrayList<>();
        addressVOList.add(addressVO);
        AddressVO addressVO1 = new AddressVO(2, "pune");
        List<AddressVO> addressVOList1 = new ArrayList<>();
        addressVOList1.add(addressVO1);
        employeeManagementVOS.stream().forEach(emp -> {
            if (emp.getEmployeeId() == 1) {
                assertEquals(emp.getEmployeeAge(), 20);
                assertEquals(emp.getEmployeeName(), "xyz");
                assertEquals(emp.getPassport(), passportVO);
                assertEquals(emp.getAddressList(), addressVOList);
            } else {
                assertEquals(emp.getEmployeeAge(), 30);
                assertEquals(emp.getEmployeeName(), "abc");
                assertEquals(emp.getPassport(), passportVO1);
                assertEquals(emp.getAddressList(), addressVOList1);
            }
        });

    }

    @Test
    public void getEmpByIdTest() throws Exception {
        int id = 1;
        PassportModel passportM1 = new PassportModel(1, "ab");
        AddressModel addressM1 = new AddressModel(1, "bhopalllllll");
        AddressModel addressM2 = new AddressModel(2, "pune");
        List<AddressModel> addressModelList1 = new ArrayList<>();
        addressModelList1.add(addressM1);
        addressModelList1.add(addressM2);
        EmployeeManagementModel employeeManagementModel = new EmployeeManagementModel(1, "xyz", 20, addressModelList1, passportM1);
        EmployeeManagementVO expected = dozerBeanMapper.map(employeeManagementModel, EmployeeManagementVO.class);
        when(employeeManagementRepository.findByEmployeeId(id)).thenReturn(employeeManagementModel);
        assertEquals(expected, employeeManagementService.getById(id));

        List<EmployeeManagementVO> employeeManagementVOS = employeeManagementService.getAllEmp();
        assertNotNull(employeeManagementVOS);

        PassportVO passportVo = new PassportVO(1, "ab");
        AddressVO addressVo1 = new AddressVO(1, "bhopalllllll");
        AddressVO addressVo2 = new AddressVO(2, "pune");
        List<AddressVO> addressVoList1 = new ArrayList<>();
        addressVoList1.add(addressVo1);
        addressVoList1.add(addressVo2);

        for (EmployeeManagementVO emp : employeeManagementVOS) {
            assertEquals(emp.getEmployeeAge(), 20);
            assertEquals(emp.getEmployeeName(), "xyz");
            assertEquals(emp.getAddressList(), addressVoList1);
            assertEquals(emp.getPassport(), passportVo);
        }

    }

    @Test()
    public void getEmpByIdTestException() {
        int id = 1;
        when(employeeManagementRepository.findByEmployeeId(id)).thenReturn(null);
        assertThrows(EmployeeNotFound.class, () -> {
            employeeManagementService.getById(id);
        });
    }

    @Test
    public void saveEmployeeTest() {
        PassportVO passportVO = new PassportVO(1, "ab");
        AddressVO addressVO = new AddressVO(1, "bhopalllllll");
        List<AddressVO> addressVOList = new ArrayList<>();
        addressVOList.add(addressVO);
        EmployeeManagementVO employeeManagementVO = new EmployeeManagementVO(1, "xyz", 66, addressVOList, passportVO);
        EmployeeManagementModel employeeManagementModel = dozerBeanMapper.map(employeeManagementVO, EmployeeManagementModel.class);
        when(employeeManagementRepository.save(employeeManagementModel)).thenReturn(employeeManagementModel);
        assertEquals(employeeManagementVO, employeeManagementService.createEmp(employeeManagementVO));

        List<EmployeeManagementVO> employeeManagementVOS = employeeManagementService.getAllEmp();
        assertNotNull(employeeManagementVOS);

        for (EmployeeManagementVO emp : employeeManagementVOS) {
            assertEquals(emp.getEmployeeAge(), 66);
            assertEquals(emp.getEmployeeName(), "xyz");
            assertEquals(emp.getAddressList(), addressVO);
            assertEquals(emp.getPassport(), passportVO);
        }
    }


    @Test
    public void getEmpByNameTest() throws Exception {
        String name = "prerna";
        EmployeeManagementModel employeeManagementModel = new EmployeeManagementModel(1, "xyz", 20, null, null);
        EmployeeManagementVO expected = dozerBeanMapper.map(employeeManagementModel, EmployeeManagementVO.class);
        when(employeeManagementRepository.findByEmployeeName(name)).thenReturn(employeeManagementModel);
        assertEquals(expected, employeeManagementService.getByName(name));

        List<EmployeeManagementVO> employeeManagementVOS = employeeManagementService.getAllEmp();
        assertNotNull(employeeManagementVOS);

        for (EmployeeManagementVO emp : employeeManagementVOS) {
            assertEquals(emp.getEmployeeAge(), 20);
            assertEquals(emp.getEmployeeName(), "xyz");
        }
    }

    @Test()
    public void getEmpByNameTestException() {
        String name = "prerna";
        when(employeeManagementRepository.findByEmployeeName(name)).thenReturn(null);
        assertThrows(EmployeeNotFound.class, () -> {
            employeeManagementService.getByName(name);
        });
    }

    @Test
    public void deleteEmpTest() throws Exception {
        int id = 1;
        EmployeeManagementModel employeeManagementModel = new EmployeeManagementModel(1, "xyz", 20, null, null);
        when(employeeManagementRepository.findByEmployeeId(id)).thenReturn(employeeManagementModel);
        employeeManagementService.deleteByEmployeeId(id);
        verify(employeeManagementRepository, Mockito.times(1)).deleteById(id);
    }

}