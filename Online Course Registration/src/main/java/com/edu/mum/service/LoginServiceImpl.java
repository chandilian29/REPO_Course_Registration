/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.edu.mum.dao.LoginDao;
import com.mum.edu.domain.Administrator;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.MyUser;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sandy
 */
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public LoginServiceImpl() {
    }

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public MyUser getUser(String uname) {
        return loginDao.getUser(uname);
    }

    public Administrator getAdministrator(String uname){
        return loginDao.getAdministrator(uname);
    }
    public Faculty getFaculty(String uname){
        return loginDao.getFaculty(uname);
    }
     public Customer getCustomer(String uname){
        return loginDao.getCustomer(uname);
    }
    
    @Transactional
    @Override
    public void addMyUser(MyUser myUser) {
        loginDao.addMYUser(myUser);
    }

    @Override
    public MyUser addMyUser(long id, String firstName, String lastName, String address, String phoneNo, String uname, String password, String usertype) {
        MyUser user = new MyUser(id, firstName, lastName, address, phoneNo, uname, password, usertype);
        loginDao.addMYUser(user);
        return user;
    }
    @Override
    public boolean isFacultyExist(String user_id){
        return loginDao.isUserExist(user_id);
    }
    @Override
    public boolean isAdministratorExist(String user_id){
        return loginDao.isAdministratorExist(user_id);
    }
    @Override
    public boolean isCustomerExist(String user_id){
        return loginDao.isCustomerExist(user_id);
    }
    @Override
    public void update(int userID, Customer customer) {
        loginDao.update(userID, customer);
    }

}
