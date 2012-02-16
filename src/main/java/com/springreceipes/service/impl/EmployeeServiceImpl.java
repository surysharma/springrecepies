package com.springreceipes.service.impl;

import com.springreceipes.service.EmployeeService;
import com.springreceipes.service.PayrollService;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 14/01/2012
 * Time: 22:57
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private PayrollService payrollService;

    @Override
    public String computeEmployeeSalary(String employeeId) {
        String payrollNumber = payrollService.getPayrollNumber(employeeId);
        return payrollNumber;
    }

    public void setPayrollService(PayrollService payrollService) {
        this.payrollService = payrollService;
    }
}
