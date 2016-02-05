/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mum.dao;

import com.mum.edu.domain.Faculty;
import com.mum.edu.domain.Section;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pAlahakoon
 */
@Transactional
public class SectionDaoImpl implements SectionDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSection(Section section) {
        sessionFactory.getCurrentSession().persist(section);
    }

    @Override
    public List<Section> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Section");
        return query.list();
    }

    @Override
    public Section get(int id) {
        return (Section) sessionFactory.getCurrentSession().load(Section.class, id);
    }

    @Override
    public void update(int id, Section section) {
        Section s = get(id);
        s.setSectionId(section.getSectionId());
        s.setSectionName(section.getSectionName());
        s.setSectionSize(section.getSectionSize());
        s.setNoOfDays(section.getNoOfDays());
//        section.setId(id);
//        sessionFactory.getCurrentSession().merge(section);
    }

    @Override
    public Section getSection(String sectionName) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select s from Section s where s.sectionName=:sectionName");
        query.setParameter("sectionName", sectionName);
        return (Section) query.list().get(0);
    }

    @Override
    public void delete(int id) {
        Section s = get(id);
        sessionFactory.getCurrentSession().delete(s);
    }

    @Override
    public Faculty getFacultyId(int id) {
        return (Faculty) sessionFactory.getCurrentSession().load(Faculty.class, id);
    }

    @Override
    public List<Faculty> getAllFaculty() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Faculty");
        return query.list();
    }

    public Faculty getFacultybyFirstName(String firstName) {
        Query query = sessionFactory.getCurrentSession().createQuery("Select p from Faculty p where p.firstName=:firstName");
        query.setParameter("firstName", firstName);
        return (Faculty) query.list().get(0);
    }

    @Override
    public void updateFaculty(int id, Section section) {
        Section s = get(id);
        s.setFaculty(section.getFaculty());
    }

}
