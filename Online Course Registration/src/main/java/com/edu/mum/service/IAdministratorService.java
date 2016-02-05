/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.service;


import com.edu.mum.dao.IAdministratorDAO;
import com.mum.edu.domain.Administrator;
import java.util.List;

/**
 *
 * @author Uguudei
 */
public interface IAdministratorService {
    public void setAdminDAO(IAdministratorDAO adminDAO);
    public Administrator createAdministrator(Administrator admin);
    public Administrator getAdministrator(int id);
    public void updateAdministrator(int adminId, Administrator admin);
    public void deleteAdministrator(int adminId);
    public List<Administrator> getAdministrators();
    public boolean isAdministratorExist(String user_id);
}
