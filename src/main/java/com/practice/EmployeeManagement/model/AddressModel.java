package com.practice.EmployeeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * This is the model class of address having addressId , city as attributes.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressModel {
    @Id
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "house_number")
    private String city;
}
