/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.service;

import com.edu.mum.dao.IYogaCourseDAO;
import com.mum.edu.domain.Course;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Section;
import java.util.List;

/**
 *
 * @author Yonas
 */
public class YogaCourseService implements IYogaCourseService {

    private IYogaCourseDAO yogaCourseDAO;

    public YogaCourseService() {
    }

    public YogaCourseService(IYogaCourseDAO yogaCourseDAO) {
        this.yogaCourseDAO = yogaCourseDAO;
    }

    @Override
    public List<Course> getAllCourse() {
        return yogaCourseDAO.getAllCourse();
    }

    @Override
    public List<Section> getAllSection() {
        return yogaCourseDAO.getAllSection();
    }

    @Override
    public List<Section> getRegisteredSectionsByCusomerId(int customerId) {
        return getRegisteredSectionsByCusomerId(customerId);
    }

    @Override
    public List<Course> getCourseListByName(String courseName) {
        return yogaCourseDAO.getCourseListByName(courseName);

    }

//    public void updateSection(Section section) {
//        yogaCourseDAO.updateSection(section);
//
//    }
//
//    public void dropSection(Customer customer, String sectionId) {
//        yogaCourseDAO.registerForSection(customer, sectionId);
//    }
    @Override
    public Section getSectionById(String sectionId) {
        return yogaCourseDAO.getSectionById(sectionId);
    }

    @Override
    public Course getCourseById(String courseId) {
        return yogaCourseDAO.getCourseById(courseId);
    }

    @Override
    public List<Section> getSectionsByCourseId(String courseId) {
        return yogaCourseDAO.getSectionsByCourseId(courseId);
    }

    @Override
    public void registerCustomer(Section section) {

        yogaCourseDAO.registerCustomer(section);
    }

    @Override
    public List<Section> getSectionsByCustomerId(int customerId) {
        return yogaCourseDAO.getSectionsByCustomerId(customerId);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return yogaCourseDAO.getCustomerById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        yogaCourseDAO.updateCustomer(customer);
    }

    @Override
    public void updateSection(Section section) {
        yogaCourseDAO.updateSection(section);
    }
     @Override 
    public void dropSection(int sectionId, int customerId){
        yogaCourseDAO.dropSection(sectionId,customerId);
    }
}
