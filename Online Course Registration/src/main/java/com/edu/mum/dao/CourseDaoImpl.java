/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Course;
import com.mum.edu.domain.Section;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jevin
 */
@Transactional
public class CourseDaoImpl implements CourseDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCourse(Course course) {
        sessionFactory.getCurrentSession().persist(course);
    }

    @Override
    public List<Course> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Course");
        return query.list();
    }

    @Override
    public Course get(int id) {
        return (Course) sessionFactory.getCurrentSession().load(Course.class, id);
    }

    @Override
    public void update(int id, Course course) {
        sessionFactory.getCurrentSession().update(course);
    }

    @Override
    public void delete(int id) {
        Course c = get(id);
        sessionFactory.getCurrentSession().delete(c);
    }

    @Override
    public Course getCourse(String courseName) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select c from Course c where c.courseName=:courseName");
        query.setParameter("courseName", courseName);
        return (Course) query.list().get(0);
    }

    @Override
    public void addSection(Section section) {
        sessionFactory.getCurrentSession().save(section);
    }

    @Override
    public List<Section> getSectionsByCourseId(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select s from Section s where s.course.id=:id");
        query.setParameter("id", id);
        return (List<Section>) query.list();
    }

    @Override
    public void addPrerequisiteToCourse(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public List<Course> getPrerequisteByCourseId(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select p from Course c join c.prerequestic p where c.id=:id");
        query.setParameter("id", id);
        return (List<Course>) query.list();
    }


}
