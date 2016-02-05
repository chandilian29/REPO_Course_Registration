/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.service;

import com.edu.mum.dao.IFacultyDAO;
import com.mum.edu.domain.Faculty;
import java.util.List;

/**
 *
 * @author Uguudei
 */
public class FacultyService implements IFacultyService{
    private IFacultyDAO facultyDAO;

    public FacultyService() {
    }

    @Override
    public void setFacultyDAO(IFacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }
    
    @Override
    public Faculty createFaculty(Faculty faculty){
        facultyDAO.add(faculty);
        return faculty;
    }

    
    
    @Override
    public Faculty getFaculty(int id){
     return facultyDAO.get(id);
    }
    
    @Override
    public void updateFaculty(int facultyId, Faculty faculty){
        facultyDAO.update(facultyId, faculty);
    }
    
    @Override
    public void deleteFaculty(int facultyId){
        facultyDAO.delete(facultyId);
    }
    
    @Override
    public List<Faculty> getFaculties(){
        return facultyDAO.getAll();
    }
    
    @Override
    public boolean isFacultyExist(String user_id){
        return facultyDAO.isUserExist(user_id);
    }
}
