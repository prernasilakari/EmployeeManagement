package com.practice.EmployeeManagement.service;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class EmployeeManagementServiceHelper {

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

}
