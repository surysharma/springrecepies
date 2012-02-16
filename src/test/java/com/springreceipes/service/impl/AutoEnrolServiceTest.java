package com.springreceipes.service.impl;


import com.google.common.collect.Lists;
import com.springreceipes.domain.Employee;
import com.springreceipes.domain.InvestmentProductAllocation;
import com.springreceipes.service.AutoEnrolService;
import com.springreceipes.service.PensionApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AutoEnrolServiceTest {

    @Mock
    private PensionApplicationService pensionApplicationService;

    @InjectMocks
    private AutoEnrolService autoEnrolService = new AutoEnrolServiceImpl();

    @Test
    public void shouldAutoEnrolEmployee() {
        //Given
        Employee employee = new Employee();
         InvestmentProductAllocation allocation = new InvestmentProductAllocation();
        employee.setAllocation(allocation);

        //When
        autoEnrolService.autoEnrol(employee);

        //Then
        List<InvestmentProductAllocation> allocations = Lists.newArrayList();
//        ArgumentCaptor<List<InvestmentProductAllocation>> captor = ArgumentCaptor.forClass(List.<InvestmentProductAllocation>class);
        ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<Boolean> captorB = ArgumentCaptor.forClass(Boolean.class);

//        verify(pensionApplicationService).submitPensionApplication(Matchers.<Employee>any(Employee.class), captor.capture());
        Boolean sendMail = new Boolean(true);
        verify(pensionApplicationService).submitPensionApplication(Matchers.<Employee>any(Employee.class), captor.capture(), captorB.capture());
        assertNotNull(captor.getValue());

//        ArgumentCaptor<InvestmentProductAllocation> captor = ArgumentCaptor.forClass(InvestmentProductAllocation.class);
//        verify(pensionApplicationService).submitPensionApplication(Matchers.<Employee>any(Employee.class), captor.capture());
//        assertEquals(captor.getValue(), allocation);

//        ArgumentCaptor<InvestmentProductAllocation> captor = ArgumentCaptor.forClass(InvestmentProductAllocation.class);
//        verify(pensionApplicationService).submitPensionApplication(Matchers.<Employee>any(Employee.class), captor.capture());
//        assertEquals(captor.getValue(), allocation);
    }

}
