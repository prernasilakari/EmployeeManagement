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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "address_sequence", initialValue = 1)
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "house_number")
    private String city;

    @Override
    public String toString() {
        return "{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                '}';
    }
}
