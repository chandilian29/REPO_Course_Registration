/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Course;
import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.Section;
import java.util.List;

/**
 *
 * @author Jevin
 */
public interface CourseDao {

    public void addCourse(Course course);

    public List<Course> getAll();

    public Course get(int id);

    public void update(int id, Course course);

    public void delete(int id);

    public Course getCourse(String courseName);
    
    public void addSection(Section section);
    
    public List<Section> getSectionsByCourseId(int id);
    
    public void addPrerequisiteToCourse(Course course);
    
    public List<Course> getPrerequisteByCourseId(int id);
    
  
    
 

}
