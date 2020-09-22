package com.practice.EmployeeManagement.model;

import lombok.*;

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
@Table(name = "employee_table")
public class EmployeeManagementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "employee_sequence", initialValue = 1)
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
