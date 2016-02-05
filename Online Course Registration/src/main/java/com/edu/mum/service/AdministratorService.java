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
public class AdministratorService implements IAdministratorService{
    private IAdministratorDAO adminDAO;

    public AdministratorService() {
    }

    @Override
    public void setAdminDAO(IAdministratorDAO adminDAO) {
        this.adminDAO = adminDAO;
    }
    
    @Override
    public Administrator createAdministrator(Administrator admin){
        adminDAO.add(admin);
        return admin;
    }
    
    @Override
    public Administrator getAdministrator(int id){
     return adminDAO.get(id);
    }
    
    @Override
    public void updateAdministrator(int adminId, Administrator admin){
        adminDAO.update(adminId, admin);
    }
    
    @Override
    public void deleteAdministrator(int adminId){
        adminDAO.delete(adminId);
    }
    
    @Override
    public List<Administrator> getAdministrators(){
        return adminDAO.getAll();
    }
    
    @Override
    public boolean isAdministratorExist(String user_id){
        return adminDAO.isUserExist(user_id);
    }
}
