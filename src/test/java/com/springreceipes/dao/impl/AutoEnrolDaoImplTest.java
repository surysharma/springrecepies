package com.springreceipes.dao.impl;


import com.springreceipes.dao.AutoEnrolDao;
import com.springreceipes.domain.Employee;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = {"/testApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AutoEnrolDaoImplTest {

    @Autowired
    private AutoEnrolDao autoEnrolDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void shouldSaveAutoEnrolledEmployee() throws Exception {
        //When
        Employee employee = EmployeeBuilder.employee().build();
        autoEnrolDao.autoEnrolEmployee(employee);
        sessionFactory.getCurrentSession().flush();

        //Then
        List<Employee> expectedEmployees = sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
        assertTrue(expectedEmployees.size() > 0);
        assertThat(expectedEmployees.get(0), is(employee));
    }


}
