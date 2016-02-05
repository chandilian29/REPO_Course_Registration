/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Course;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Section;
import java.util.List;

/**
 *
 * @author Yonas
 */
public interface IYogaCourseDAO {

    public List<Course> getAllCourse();

    public List<Section> getAllSection();

    public List<Section> getRegisteredSectionsByCusomerId(int customerId);

    public List<Course> getCourseListByName(String courseName);

//    public void registerForSection(Customer customer, String sectionId);
//    public void dropSection(Customer customer, String sectionId);
//
//    public void updateSection(Section section);
    public Section getSectionById(String sectionId);

    public Course getCourseById(String courseId);

    public List<Section> getSectionsByCourseId(String courseId);

    public void registerCustomer(Section section);

    public void dropSection(Customer customer);

    public List<Section> getSectionsByCustomerId(int customerId);

    public Customer getCustomerById(int customerId);

    public void updateCustomer(Customer customer);

    public void updateSection(Section section);

    public void dropSection(int sectionId, int customerId);
}
