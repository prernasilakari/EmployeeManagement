package com.practice.EmployeeManagement.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {
    private int addressId;
    private String city;

    @Override
    public String toString() {
        return "{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                '}';
    }
}