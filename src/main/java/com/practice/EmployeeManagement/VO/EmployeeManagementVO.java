package com.practice.EmployeeManagement.VO;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;

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

    @Override
    public String toString() {
        return "{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", addressList=" + addressList +
                ", passport=" + passport +
                '}';
    }
}
