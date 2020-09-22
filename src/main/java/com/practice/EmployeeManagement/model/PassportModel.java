package com.practice.EmployeeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * This is the model class of passport having passportId , name as attributes.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passport")
public class PassportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "passport_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "passport_id")
    private int passportId;
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "{" +
                "passportId=" + passportId +
                ", name='" + name + '\'' +
                '}';
    }
}