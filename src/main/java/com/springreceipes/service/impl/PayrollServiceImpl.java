package com.springreceipes.service.impl;

import com.springreceipes.service.PayrollService;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 14/01/2012
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */
public class PayrollServiceImpl implements PayrollService{

    @Override
    public String getPayrollNumber(String employeeId) {

        payrollPrivateMethod();
        return "This is a real PayrollNumber";  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void payrollPrivateMethod() {
        System.out.println("INSIDE REAL IMPL!!!");
    }
}
