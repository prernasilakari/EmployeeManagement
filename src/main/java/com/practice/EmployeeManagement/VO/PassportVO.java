package com.practice.EmployeeManagement.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportVO {
    private int passportId;
    @Mapping("name")
    private String passportName;

    @Override
    public String toString() {
        return "{" +
                "passportId=" + passportId +
                ", name='" + passportName + '\'' +
                '}';
    }
}
