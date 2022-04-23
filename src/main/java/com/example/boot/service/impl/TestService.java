package com.example.boot.service.impl;

import com.example.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    @Qualifier("employeeServiceImpl")
    private EmployeeService employeeService;

}
