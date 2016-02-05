/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;


import com.mum.edu.domain.Faculty;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Uguudei
 */ 
public interface IFacultyDAO {
    public void setSessionFactory(SessionFactory sessionFactory);
    public List<Faculty> getAll();
    public void add(Faculty faculty);
    public Faculty get(int id);
    public boolean isUserExist(String user_id);
    public void update(int facultyId, Faculty faculty);
    public void delete(int facultyId);
}
