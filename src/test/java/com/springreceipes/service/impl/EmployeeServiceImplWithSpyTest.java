package com.springreceipes.service.impl;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.springreceipes.service.PayrollService;
import com.sun.istack.internal.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplWithSpyTest {


    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldComputeEmployeeSalary() {
        //Given
        PayrollService payrollServiceSpy = spy(new PayrollServiceImpl());
        employeeService.setPayrollService(payrollServiceSpy);
        given(payrollServiceSpy.getPayrollNumber("someEmployeeId")).willReturn("Stubbed");

        //When
        String computedSalary = employeeService.computeEmployeeSalary("someEmployeeId");

        //Then
        verify((PayrollServiceImpl) payrollServiceSpy).payrollPrivateMethod();
        assertThat(computedSalary, is("Stubbed"));
    }

    @Test
    public void testFilters() {
        List<String> unfilteredCollection = Lists.newArrayList("uf1", "f1", "uf2", "f2", "uf3", "f3", "uf4", "f4");

        Collection<String> filteredCollection = Collections2.filter(unfilteredCollection, new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String s) {
                return (s.startsWith("f") ? true : false);
            }
        });
        ArrayList<String> filteredList = Lists.newArrayList(filteredCollection);
        assertThat(filteredList, is(Lists.newArrayList("f1", "f2", "f3", "f4")));

    }

    @Test
    public void testTransformers() {
        List<String> corruptCollection = Lists.newArrayList("uf1", "f1", "uf2", "f2", "uf3", "f3", "uf4", "f4");

        Collection<Object> transformedCollection = Collections2.transform(corruptCollection, new Function<String, Object>() {
            @Override
            public Object apply(@Nullable String s) {
                char Counter = s.charAt(s.indexOf("f")+1);
                return (s.startsWith("f") ? "FullyFiltered" + Counter : "unfiltered" + Counter);
            }
        });
        ArrayList<Object> transformedList = Lists.newArrayList(transformedCollection);
        /*ArrayList<String> value = Lists.newArrayList("f1", "f2", "f3", "f4");
        assertThat(transformedList, is(value));*/
        System.out.println(transformedList);
    }


}
