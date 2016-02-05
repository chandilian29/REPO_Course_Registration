/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.service;

import com.edu.mum.dao.CustomerDAO;
import com.edu.mum.dao.ICustomerDAO;
import com.mum.edu.domain.Customer;
import java.util.List;

/**
 *
 * @author Uguudei
 */
public interface ICustomerService {
    public ICustomerDAO getCustomerDAO();
    public void setCustomerDAO(ICustomerDAO customerDAO);
    public Customer createCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void updateCustomer(int customerId, Customer customer);
    public void deleteCustomer(int customerId);
    public List<Customer> getCustomers();
    public boolean isCustomerExist(String user_id);
}
