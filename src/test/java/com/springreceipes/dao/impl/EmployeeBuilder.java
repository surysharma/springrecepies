package com.springreceipes.dao.impl;

import com.springreceipes.domain.Employee;

public class EmployeeBuilder {
    private Employee employee;
    
    //Default employee state
    private Long employeeId = 999L;
    private String firstName="someFirstName";

    public static EmployeeBuilder employee() {
        return new EmployeeBuilder();
    }

    public Employee build() {
        employee = new Employee();
        employee.setId(employeeId);
        employee.setFirstName(firstName);
        return employee;  //To change body of created methods use File | Settings | File Templates.
    }

    public EmployeeBuilder withId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;  //To change body of created methods use File | Settings | File Templates.
    }
}
