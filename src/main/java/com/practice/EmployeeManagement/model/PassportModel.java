package com.practice.EmployeeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int passportId;
    private String name;
}
