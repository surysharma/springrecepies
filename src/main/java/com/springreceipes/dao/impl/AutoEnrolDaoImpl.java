package com.springreceipes.dao.impl;

import com.springreceipes.dao.AutoEnrolDao;
import com.springreceipes.domain.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AutoEnrolDaoImpl implements AutoEnrolDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void autoEnrolEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }
}
