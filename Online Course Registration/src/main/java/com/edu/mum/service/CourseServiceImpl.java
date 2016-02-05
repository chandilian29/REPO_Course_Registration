/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.edu.mum.dao.CourseDao;
import com.mum.edu.domain.Course;
import com.mum.edu.domain.Section;
import java.util.List;

/**
 *
 * @author Jevin
 */
public class CourseServiceImpl implements CourseService {
    
    private CourseDao courseDao;
    
    public CourseServiceImpl() {
    }
    
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    
    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }
    
    @Override
    public Course addCourse(int id, String courseName, String courseId, String courseDescription, int offeringsPerTime) {
        Course course = new Course(id, courseName, courseId, courseDescription, offeringsPerTime);
        courseDao.addCourse(course);
        return course;
    }
    
    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }
    
    @Override
    public Course get(int id) {
        return courseDao.get(id);
    }
    
    @Override
    public void update(int id, Course course) {
        courseDao.update(id, course);
    }
    
    @Override
    public void delete(int id) {
        courseDao.delete(id);
    }
    
    @Override
    public Course getCourse(String courseName) {
        return courseDao.getCourse(courseName);
    }
    
    @Override
    public void addSection(Section section) {
        courseDao.addSection(section);
    }
    
    @Override
    public Section addSection(int id, String sectionId, String sectionName, int noOfDays, int sectionSize) {
        Section section = new Section(id, sectionId, sectionName, noOfDays, sectionSize);
        courseDao.addSection(section);
        return section;
    }
    
    @Override
    public List<Section> getSectionsByCourseId(int id) {
        return courseDao.getSectionsByCourseId(id);
    }
    
    @Override
    public void addPrerequisiteToCourse(Course course) {
        courseDao.addPrerequisiteToCourse(course);
    }
    
    @Override
    public List<Course> getPrerequisteByCourseId(int id) {
        return courseDao.getPrerequisteByCourseId(id);
    }
    
}
