package com.springreceipes.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;

    public void setAllocation(InvestmentProductAllocation allocation) {

    }

    public void setId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    public Long getId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
