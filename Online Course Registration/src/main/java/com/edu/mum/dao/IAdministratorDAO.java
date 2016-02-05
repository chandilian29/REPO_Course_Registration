/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.Administrator;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Uguudei
 */
public interface IAdministratorDAO {
    public void setSessionFactory(SessionFactory sessionFactory);
    public List<Administrator> getAll();
    public void add(Administrator admin);
    public Administrator get(int id);
    public boolean isUserExist(String user_id);
    public void update(int adminId, Administrator admin);
    public void delete(int adminId);
}
