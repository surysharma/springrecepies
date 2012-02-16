package com.springreceipes.service;

import com.springreceipes.domain.Employee;
import com.springreceipes.domain.InvestmentProductAllocation;

import java.util.List;

public interface PensionApplicationService {
    void submitPensionApplication(Employee employee, List<InvestmentProductAllocation> allocations, Boolean sendMail);
    void submitPensionApplication(Employee employee, List<InvestmentProductAllocation> allocations);
    void submitPensionApplication(Employee employee, InvestmentProductAllocation allocation, boolean sendMail);
    void submitPensionApplication(Employee employee, InvestmentProductAllocation allocation);
}
