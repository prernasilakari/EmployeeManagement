package com.practice.EmployeeManagement.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeManagementVO {
    private int employeeId;
    private String employeeName;
    private int employeeAge;
    private List<AddressVO> addressList;
    private PassportVO passport;
}
