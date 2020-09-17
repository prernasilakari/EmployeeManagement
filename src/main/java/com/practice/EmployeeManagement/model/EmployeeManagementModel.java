package com.practice.EmployeeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This is the model class of employee having employeeId , employeeName and employeeAge as attributes.
 * It also has oneToMany maping with address and OneToOne mapping with passport.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeManagementModel {
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_age")
    private int employeeAge;
    @OneToMany
    @Column(name = "address_list")
    private List<AddressModel> addressList;
    @OneToOne
    private PassportModel passport;
}
