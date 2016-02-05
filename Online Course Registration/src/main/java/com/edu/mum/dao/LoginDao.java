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

/**
 *
 * @author Sandy
 */
public interface LoginDao {

    public void addMYUser(MyUser user);

    public MyUser getUser(String uname);
    public boolean isUserExist(String user_id);
    public Administrator getAdministrator(String uname);
    public Faculty getFaculty(String uname);
    public Customer getCustomer(String uname);
    public boolean isCustomerExist(String user_id);
    public boolean isAdministratorExist(String user_id);
    public void update(int userID, Customer customer);
}
