/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.service;

import com.edu.mum.dao.ICustomerDAO;
import com.mum.edu.domain.Customer;
import java.util.List;

/**
 *
 * @author Uguudei
 */
public class CustomerService implements ICustomerService{
    private ICustomerDAO customerDAO;

    public CustomerService() {
    }

    @Override
    public ICustomerDAO getCustomerDAO() {
        return customerDAO;
    }
    
    @Override
    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    @Override
    public Customer createCustomer(Customer customer){
        customerDAO.add(customer);
        return customer;
    }
    
    @Override
    public Customer getCustomer(int id){
     return customerDAO.get(id);
    }
    
    @Override
    public void updateCustomer(int customerId, Customer customer){
        customerDAO.update(customerId, customer);
    }
    
    @Override
    public void deleteCustomer(int customerId){
        customerDAO.delete(customerId);
    }
    
    @Override
    public List<Customer> getCustomers(){
        return customerDAO.getAll();
    }
    
    @Override
    public boolean isCustomerExist(String user_id){
        return customerDAO.isUserExist(user_id);
    }
}
