/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.mum.edu.domain.Administrator;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.MyUser;

/**
 *
 * @author Sandy
 */
public interface LoginService {

    public MyUser getUser(String uname);
    public void update(int userID, Customer customer);
    public Administrator getAdministrator(String uname);
    public Faculty getFaculty(String uname);
    public Customer getCustomer(String uname);
    public void addMyUser(MyUser myUser);
    public boolean isFacultyExist(String user_id);
    public boolean isAdministratorExist(String user_id);
    public boolean isCustomerExist(String user_id);
    public MyUser addMyUser(long id, String firstName, String lastName, String address, String phoneNo, String uname, String password, String usertype);

}
