/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Course;
import com.mum.edu.domain.Customer;
import com.mum.edu.domain.Section;
import java.util.List;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
//import org.hibernate.SessionFactory;

/**
 *
 * @author Yonas
 */
@Transactional
public class YogaCourseDAO implements IYogaCourseDAO {

    private SessionFactory sessionFactory;

    //    public void setSf(SessionFactory sessionFactory) {
    //        this.sessionFactory = sessionFactory;
    //    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> getAllCourse() {
        return sessionFactory.getCurrentSession().createQuery("From Course").list();
    }

    @Override
    public List<Section> getAllSection() {
        return sessionFactory.getCurrentSession().createQuery("From Section").list();
    }

    @Override
    public List<Section> getRegisteredSectionsByCusomerId(int customerId) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select distinct s from Section s join s.customerList c where c.id:customerId");
        query.setParameter("customerId", customerId);
        return query.list();
    }

    @Override
    public List<Course> getCourseListByName(String courseName) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select c from Course c where c.courseName=:name");
        query.setParameter("name", courseName);
        return query.list();
    }

    @Override
    public void dropSection(Customer customer) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete c from Section s join s.customers c where c.firstname=:name");
        query.setParameter("name", customer.getFirstName());
    }

    @Override
    public Section getSectionById(String sectionId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select s from Section s where s.sectionId=:sectionId");
        query.setParameter("sectionId", sectionId);
        if (query.list() == null) {
            return null;
        } else {
            return (Section) query.list().get(0);
        }
    }

    @Override
    public Course getCourseById(String courseId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select c from Course c where c.courseId=:courseId");
        query.setParameter("courseId", courseId);
        if (query.list() == null) {
            return null;
        } else {
            return (Course) query.list().get(0);
        }
    }

    @Override
    public List<Section> getSectionsByCourseId(String courseId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select s from Section s where s.course.courseId=:courseId");
        query.setParameter("courseId", courseId);
        return (List<Section>) query.list();
    }

    @Override
    public void registerCustomer(Section section) {

        sessionFactory.getCurrentSession().merge(section);
    }

    @Override
    public List<Section> getSectionsByCustomerId(int customerId) {
        int testValue = customerId;
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct s from Section s join s.customerList c where c.id=:customerId");
        query.setParameter("customerId", customerId);
        return (List<Section>) query.list();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select c from Customer c where c.id=:customerId");
        query.setParameter("customerId", customerId);
        // return (Customer) query.list().get(0);

        if (query.list() == null) {
            return null;
        } else {
            return (Customer) query.list().get(0);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);// .update(customer)        
    }

    @Override
    public void updateSection(Section section) {
        sessionFactory.getCurrentSession().update(section);// .update(customer)        
    }

    public void dropSection(int sectionId, int customerId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from customer_section where sectionId=:sectionId and customerId=:customerId");
        query.setParameter("sectionId", sectionId);
        query.setParameter("customerId", customerId);
    }
       
}
