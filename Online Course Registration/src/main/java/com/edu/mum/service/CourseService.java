/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.mum.edu.domain.Course;
import com.mum.edu.domain.Section;
import java.util.List;

/**
 *
 * @author Jevin
 */
public interface CourseService {

    public void addCourse(Course course);

    public Course addCourse(int id, String courseName, String courseId, String courseDescription, int offeringsPerTime);

    public List<Course> getAll();

    public Course get(int id);

    public void update(int id, Course course);

    public void delete(int id);

    public Course getCourse(String courseName);

    public void addSection(Section section);

    public Section addSection(int id, String sectionId, String sectionName, int noOfDays, int sectionSize);

    public List<Section> getSectionsByCourseId(int id);

    public void addPrerequisiteToCourse(Course course);

    public List<Course> getPrerequisteByCourseId(int id);

}
