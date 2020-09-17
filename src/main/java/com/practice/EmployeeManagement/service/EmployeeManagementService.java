package com.practice.EmployeeManagement.service;

import com.practice.EmployeeManagement.VO.EmployeeManagementVO;
import com.practice.EmployeeManagement.model.AddressModel;
import com.practice.EmployeeManagement.model.EmployeeManagementModel;
import com.practice.EmployeeManagement.model.PassportModel;
import com.practice.EmployeeManagement.repository.AddressRepository;
import com.practice.EmployeeManagement.repository.EmployeeManagementRepository;
import com.practice.EmployeeManagement.repository.PassportRepository;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class EmployeeManagementService implements EmployeeManagementServiceInterface {
    @Autowired
    private EmployeeManagementRepository employeeManagementRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PassportRepository passportRepository;

    /**
     * This method is used to get the details of all the employee
     *
     * @return
     */
    @Override
    public List<EmployeeManagementVO> getAllEmp() {
        Mapper mapper = new DozerBeanMapper();
        List<EmployeeManagementModel> employeeManagementModels = employeeManagementRepository.findAll();
        List<EmployeeManagementVO> employeeManagementVOS = mapper.map(employeeManagementModels, List.class);
        log.debug("model{}", employeeManagementModels);
        return employeeManagementVOS;
    }

    /**
     * This method is used to create a employee
     *
     * @param employeeManagementVO
     */
    public void createEmp(EmployeeManagementVO employeeManagementVO) {
        Mapper mapper = new DozerBeanMapper();

        List<AddressModel> addressModels = new ArrayList<>();
        employeeManagementVO.getAddressList().stream().forEach(addressVO ->
                {
                    AddressModel addressModel = mapper.map(addressVO, AddressModel.class);
                    addressModels.add(addressModel);
                }
        );
        addressRepository.saveAll(addressModels);
        PassportModel passportModel = new DozerBeanMapper().map(employeeManagementVO.getPassport(), PassportModel.class);
        passportRepository.save(passportModel);
        EmployeeManagementModel employeeManagementModel = mapper.map(employeeManagementVO, EmployeeManagementModel.class);
        employeeManagementModel.setAddressList(addressModels);
        employeeManagementModel.setPassport(passportModel);
        employeeManagementRepository.save(employeeManagementModel);
    }

    /**
     * This method is used to get the employee detail by their id
     *
     * @param id
     * @return
     */
    public EmployeeManagementVO getById(int id) {
        Mapper mapper = new DozerBeanMapper();
        EmployeeManagementModel employeeManagementModel = employeeManagementRepository.findById(id);
        EmployeeManagementVO employeeManagementVO = mapper.map(employeeManagementModel, EmployeeManagementVO.class);
        return employeeManagementVO;
    }


}
