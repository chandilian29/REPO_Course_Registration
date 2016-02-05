/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.Customer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Uguudei
 */

@Transactional
public class CustomerDAO implements ICustomerDAO{
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
       
    @Override
    public List<Customer> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Customer");
        return q.list();
    }

    @Override
    public void add(Customer customer) {
        sessionFactory.getCurrentSession().persist(customer);
    }

    @Override
    public Customer get(int id) {
        return (Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
    }

    @Override
    public boolean isUserExist(String user_id){
        Query qr = sessionFactory.getCurrentSession().createQuery("from Customer where username = :username");
        qr.setParameter("username", user_id);
        boolean result = true;
        if(qr.list().isEmpty())
            result = false;
        return  result;//(qr.list().get(0) != null);
    }
    
    @Override
    public void update(int customerId, Customer customer) {
        customer.setId(customerId);
        sessionFactory.getCurrentSession().merge(customer);
    }

    @Override
    public void delete(int customerId) {
        Customer c = get(customerId);
        sessionFactory.getCurrentSession().delete(c);
    }
}
