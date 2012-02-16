package com.springreceipes.service.impl;

import com.google.common.collect.Lists;
import com.springreceipes.domain.Employee;
import com.springreceipes.domain.InvestmentProductAllocation;
import com.springreceipes.service.AutoEnrolService;
import com.springreceipes.service.PensionApplicationService;

import java.util.List;

public class AutoEnrolServiceImpl implements AutoEnrolService {

    private PensionApplicationService pensionApplicationService;

    @Override
    public void autoEnrol(Employee employee) {
        List<InvestmentProductAllocation> allocations = Lists.newArrayList();
//        pensionApplicationService.submitPensionApplication(employee, allocations);
        pensionApplicationService.submitPensionApplication(employee, allocations, true);
        InvestmentProductAllocation allocation = new InvestmentProductAllocation();
//        pensionApplicationService.submitPensionApplication(employee, allocation, true);
//        pensionApplicationService.submitPensionApplication(employee, allocation);
    }
}
