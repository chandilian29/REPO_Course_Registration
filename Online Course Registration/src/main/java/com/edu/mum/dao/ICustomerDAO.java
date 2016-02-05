/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.Customer;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Uguudei
 */
public interface ICustomerDAO {
    public void setSessionFactory(SessionFactory sessionFactory);
    public List<Customer> getAll();
    public void add(Customer customer);
    public Customer get(int id);
    public boolean isUserExist(String user_id);
    public void update(int customerId, Customer customer);
    public void delete(int customerId);
}
