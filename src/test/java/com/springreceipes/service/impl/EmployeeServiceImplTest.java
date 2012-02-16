package com.springreceipes.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private PayrollServiceImpl payrollService;
    @InjectMocks
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldComputeEmployeeSalary() {
        //Given
        String employeeId = "someEmployeeId";
        //When
        employeeService.computeEmployeeSalary(employeeId);

        //Then
        verify(payrollService).getPayrollNumber(employeeId);
    }
}
