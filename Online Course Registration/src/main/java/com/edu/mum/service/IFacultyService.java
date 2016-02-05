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
public interface IFacultyService {
    public void setFacultyDAO(IFacultyDAO facultyDAO);
    public Faculty createFaculty(Faculty faculty);
    public Faculty getFaculty(int id);
    public void updateFaculty(int facultyId, Faculty faculty);
    public void deleteFaculty(int facultyId);
    public List<Faculty> getFaculties();
    public boolean isFacultyExist(String user_id);
}
