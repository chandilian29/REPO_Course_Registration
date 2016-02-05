/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Administrator;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.MyUser;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sandy
 */
@Transactional
public class LoginDaoImpl implements LoginDao {

    private SessionFactory sf;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    @Override
    public void addMYUser(MyUser user) {
        sf.getCurrentSession().persist(user);
    }

    @Override
    public MyUser getUser(String uname) {
        Query query = sf.getCurrentSession().createQuery("Select u from MyUser u where u.uname=:uname");
        query.setParameter("uname", uname);
        return (MyUser) query.list().get(0);
    }

    @Override
    public Administrator getAdministrator(String uname) {
        Query query = sf.getCurrentSession().createQuery("Select u from Administrator u where u.username=:uname");
        query.setParameter("uname", uname);
        return (Administrator) query.list().get(0);
    }

    @Override
    public Faculty getFaculty(String uname) {
        Query query = sf.getCurrentSession().createQuery("Select u from Faculty u where u.username=:uname");
        query.setParameter("uname", uname);
        return (Faculty) query.list().get(0);
    }

    public Customer getCustomer(String uname) {
        Query query = sf.getCurrentSession().createQuery("Select u from Customer u where u.username=:uname");
        query.setParameter("uname", uname);
        return (Customer) query.list().get(0);
    }

    @Override
    public boolean isUserExist(String user_id) {
        Query qr = sf.getCurrentSession().createQuery("from Faculty where username = :username");
        qr.setParameter("username", user_id);
        boolean result = true;
        if (qr.list().isEmpty()) {
            result = false;
        }
        return result;//(qr.list().get(0) != null);
    }

    @Override
    public boolean isCustomerExist(String user_id) {
        Query qr = sf.getCurrentSession().createQuery("from Customer where username = :username");
        qr.setParameter("username", user_id);
        boolean result = true;
        if (qr.list().isEmpty()) {
            result = false;
        }
        return result;//(qr.list().get(0) != null);
    }

    @Override
    public boolean isAdministratorExist(String user_id) {
        Query qr = sf.getCurrentSession().createQuery("from Administrator where username = :username");
        qr.setParameter("username", user_id);
        boolean result = true;
        if (qr.list().isEmpty()) {
            result = false;
        }
        return result;//(qr.list().get(0) != null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(int userID, Customer customer) {
        Customer u = getUserByID(userID);
        u.setFirstName(customer.getFirstName());
        u.setLastName(customer.getLastName());
        u.setAddress(customer.getAddress());
        u.setPhoneNo(customer.getPhoneNo());
        u.setUsername(customer.getUsername());
        u.setPassword(customer.getPassword());
    }

    public Customer getUserByID(int userID) {
        return (Customer) sf.getCurrentSession().load(Customer.class, userID);
    }
}
